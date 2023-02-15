package com.KeaweAquarian.ExpenseTracker.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="users")
public class User {

    @Id
    private String id;

    private String  name;

    private String email;

}
