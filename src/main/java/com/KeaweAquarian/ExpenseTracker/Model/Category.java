package com.KeaweAquarian.ExpenseTracker.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="category")
public class Category {
    @Id
    private Long id;

    private String name;



}
