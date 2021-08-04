package com.example.megafontesttask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя учётной записи оператора
     */
    private String account;

    /**
     * Принадлежность к группам оператора
     */
    @ManyToMany(mappedBy = "operators")
    private Set<Groups> groups = new HashSet<>();

}
