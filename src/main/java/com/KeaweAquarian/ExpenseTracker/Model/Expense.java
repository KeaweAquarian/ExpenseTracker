package com.KeaweAquarian.ExpenseTracker.Model;

import com.KeaweAquarian.ExpenseTracker.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

/**
 * @author Keawe Aquarian
 * @version 1.0
 * @since 01/01/2023
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="expense")
public class Expense {

    @Id
    @SequenceGenerator(
            name="expense_sequence",
            sequenceName = "expense_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="expense_sequence")
    private Long id;

    private float amount;

    private Date expensedate;

    private String description;

    private String location;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;


}
