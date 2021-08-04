package com.example.megafontesttask.repository;

import com.example.megafontesttask.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Groups, Long> {
}
