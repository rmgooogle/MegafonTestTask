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
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Взаимосвязь с операторами
     * "В одной группе может состоять много операторов."
     * "Тегами оператора считается объединение тегов всех групп, в которых состоит оператор."
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "operator_groups",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "operator_id"))
    private Set<Operator> operators = new HashSet<>();

    /**
     * Взаимосвязь с тегами
     * "Одной группе может быть назначено много тегов"
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groups")
    Set<Tag> tagSet = new HashSet<>();
}
