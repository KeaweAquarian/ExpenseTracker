package com.KeaweAquarian.ExpenseTracker.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Keawe Aquarian
 * @version 1.0
 * @since 01/01/2023
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="roles")
public class Role {
    @Id
    @SequenceGenerator(
            name="roles_sequence",
            sequenceName = "roles_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="roles_sequence")
    private Long id;

    private String  name;
}
