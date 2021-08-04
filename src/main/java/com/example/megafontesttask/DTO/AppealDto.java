package com.example.megafontesttask.DTO;

import com.example.megafontesttask.model.Appeal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppealDto {

    /**
     * {@link Appeal#getId()}
     */
    private Long id;

    /**
     * {@link Appeal#getCreateDate()}
     * */
    private LocalDate createDate;

    /**
     * {@link Appeal#getWeight()}
     */
    private Integer weight;

    /**
     * {@link Appeal#getTagSet()}
     */
    Set<TagDto> tagSet;
}
