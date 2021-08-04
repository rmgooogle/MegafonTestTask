package com.example.megafontesttask.controller;

import com.example.megafontesttask.DTO.AppealDto;
import com.example.megafontesttask.service.GlobalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class OperatorController {
    private final GlobalService globalService;

    public OperatorController(GlobalService globalService) {
        this.globalService = globalService;
    }

    @GetMapping("/appeals/find/{OPERATOR_NAME}")
    public Set<AppealDto> getAppealByOperatorName(@PathVariable String OPERATOR_NAME) {
        return globalService.getAppealByOperatorName(OPERATOR_NAME);
    }

    @GetMapping("/appeals/find/sort/{OPERATOR_NAME}")
    public Set<AppealDto> getSortAppealByOperatorName(@PathVariable String OPERATOR_NAME) {
        return globalService.getSortAppealByOperatorName(globalService.getAppealByOperatorName(OPERATOR_NAME));
    }
}
