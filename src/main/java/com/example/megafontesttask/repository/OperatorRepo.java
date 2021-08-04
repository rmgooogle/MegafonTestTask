package com.example.megafontesttask.repository;

import com.example.megafontesttask.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepo extends JpaRepository<Operator, Long> {
    Operator getOperatorByAccount(String account);
}
