package com.example.megafontesttask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * имя тега
     */
    private String name;

    /**
     * Взаимосвязь с обращениями
     * "У одного обращения может быть много тегов."
     */
    @ManyToOne
    @JoinColumn(name = "appeal_id")
    private Appeal appeal;

    /**
     * Взаимосвязь с группами
     * "Одной группе может быть назначено много тегов"
     */
    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Groups groups;

}
