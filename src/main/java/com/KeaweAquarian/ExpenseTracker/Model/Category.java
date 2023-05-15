package com.KeaweAquarian.ExpenseTracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * @author Keawe Aquarian
 * @version 1.0
 * @since 01/01/2023
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="category")
public class Category {
    @Id
    @SequenceGenerator(
            name="expense_sequence",
            sequenceName = "expense_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="expense_sequence")
    private Long id;

    private String name;

}
