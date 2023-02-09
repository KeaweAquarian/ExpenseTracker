package com.KeaweAquarian.ExpenseTracker.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

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

    @OneToMany
    private Set<Catagory> category;

}
