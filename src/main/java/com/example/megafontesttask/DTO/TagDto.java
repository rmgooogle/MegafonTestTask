package com.example.megafontesttask.DTO;

import com.example.megafontesttask.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

    /**
     * {@link Tag#getId()}
     */
    private Long id;

    /**
     * {@link Tag#getName()}
     */
    private String name;
}
