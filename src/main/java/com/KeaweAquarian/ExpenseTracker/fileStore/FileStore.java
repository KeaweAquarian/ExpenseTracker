package com.KeaweAquarian.ExpenseTracker.fileStore;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;


/**
 * @author Keawe Aquarian
 * @version 1.0
 * @since 01/01/2023
 */
//Images stored in AWS bucket
@Service
public class FileStore {
    private final AmazonS3 s3;

    @Autowired
    public FileStore(AmazonS3 s3){
        this.s3 = s3;
    }

    //Method to check and add image to bucket
    public void save(String path, String fileName, Optional<Map<String, String>> optionalMetadata,
                     InputStream inputStream){
        ObjectMetadata metadata = new ObjectMetadata();
        optionalMetadata.ifPresent(map -> {
            if (!map.isEmpty()){
                map.forEach(metadata::addUserMetadata);
            }
        });
        try {
            s3.putObject(path, fileName, inputStream, metadata);
        }catch (AmazonServiceException e){
            throw  new IllegalStateException("Failed to store file", e);
        }
    }

    //Method to download image from AWS bucket
    public byte[] download(String path, String key) {
        try {
            S3Object object = s3.getObject(path, key);
            S3ObjectInputStream inputStream = object.getObjectContent();
            return IOUtils.toByteArray(inputStream);
        }catch (AmazonServiceException e){
            throw new IllegalStateException("Failed to download file to s3", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
