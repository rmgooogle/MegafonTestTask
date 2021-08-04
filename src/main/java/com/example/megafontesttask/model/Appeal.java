package com.example.megafontesttask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Дата создания обращения
     */
    private LocalDate createDate;

    /**
     * Вес обращения
     */
    private Integer weight;

    /**
     * Взаимосвязь с тегами
     * "У одного обращения может быть много тегов"
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appeal")
    Set<Tag> tagSet = new HashSet<>();
}
