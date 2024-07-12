package com.org.repository;

import com.org.models.ExpenseUser;
import com.org.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Integer> {

    List<ExpenseUser> findAllByUser(User user);
}
