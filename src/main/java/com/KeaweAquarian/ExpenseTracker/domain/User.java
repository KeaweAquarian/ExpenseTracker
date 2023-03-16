package com.KeaweAquarian.ExpenseTracker.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Keawe Aquarian
 * @version 1.0
 * @since 01/01/2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="user_sequence")
    private Long id;

    private String  name;

    private String userName;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

}
