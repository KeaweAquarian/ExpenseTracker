package com.KeaweAquarian.ExpenseTracker.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name=("user"))
public class User {
    @Id
    private Long id;

    private String name;
    private String email;

}
