package com.KeaweAquarian.ExpenseTracker.bucket;

//Amazon bucket
public enum BucketName {
    PROFILE_IMAGE("keawe-aws-image-upload-123");
    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
