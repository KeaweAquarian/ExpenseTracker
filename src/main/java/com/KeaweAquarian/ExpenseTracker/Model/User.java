package com.KeaweAquarian.ExpenseTracker.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
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

    private String  nameName;

    private String lastName;

    private String email;

}
