package com.example.megafontesttask.service;

import com.example.megafontesttask.DTO.AppealDto;
import com.example.megafontesttask.model.Appeal;
import com.example.megafontesttask.model.Groups;
import com.example.megafontesttask.model.Tag;
import com.example.megafontesttask.repository.AppealRepo;
import com.example.megafontesttask.repository.OperatorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GlobalServiceImpl implements GlobalService {

    private final OperatorRepo operatorRepo;
    private final AppealRepo appealRepo;
    private final ModelMapper modelMapper;

    public GlobalServiceImpl(OperatorRepo operatorRepo, AppealRepo appealRepo, ModelMapper modelMapper) {
        this.operatorRepo = operatorRepo;
        this.appealRepo = appealRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<AppealDto> getAppealByOperatorName(String name) {
        Long operatorId = operatorRepo.getOperatorByAccount(name).getId(); //Получение id по имени учетной записи(предположил, что имя уникальное)
        Set<Tag> operatorTags = operatorRepo.getById(operatorId).getGroups() //получение всех тегов оператора
                .stream()
                .map(Groups::getTagSet)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        Set<Appeal> resultAppeal = new HashSet<>();
        List<Appeal> appeals = appealRepo.findAll();
        for (Appeal appeal : appeals) {
            if (operatorTags.containsAll(appeal.getTagSet())) {  //проверка соответсвия тегов оператора и тегов обращения
                resultAppeal.add(appeal);
            }
        }

        return resultAppeal.stream()     //предоставление всех обращений, которые соответствуют
                .map(appeal -> modelMapper.map(appeal, AppealDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<AppealDto> getSortAppealByOperatorName(Set<AppealDto> appealDtos) {

        return appealDtos.stream() //предоставление обращения с наибольшим весом, с наиболее ранней датой
                .sorted((Comparator.comparing(AppealDto::getWeight)))
                .sorted(Comparator.comparing(AppealDto::getCreateDate))
                .limit(1)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}