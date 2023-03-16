package com.KeaweAquarian.ExpenseTracker.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
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
