package com.example.megafontesttask.service;

import com.example.megafontesttask.DTO.AppealDto;

import java.util.Set;

public interface GlobalService {

    Set<AppealDto> getAppealByOperatorName(String name);

    Set<AppealDto> getSortAppealByOperatorName(Set<AppealDto> appealDtos);


}
