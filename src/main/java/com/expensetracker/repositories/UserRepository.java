package com.expensetracker.repositories;

import com.expensetracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByLogin(String login);

    User findByEmail(String email);

}
