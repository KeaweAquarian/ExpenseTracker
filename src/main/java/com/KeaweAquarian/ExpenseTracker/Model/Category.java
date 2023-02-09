package com.KeaweAquarian.ExpenseTracker.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {
    @Id
    private int id;
    //Categories to connect to user
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

}
