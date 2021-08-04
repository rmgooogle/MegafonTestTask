package com.example.megafontesttask.repository;

import com.example.megafontesttask.model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealRepo extends JpaRepository <Appeal, Long> {
}
