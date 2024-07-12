package com.org.repository;

import com.org.models.Expense;
import com.org.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Override
    Optional<Group> findById(Integer integer);
}

