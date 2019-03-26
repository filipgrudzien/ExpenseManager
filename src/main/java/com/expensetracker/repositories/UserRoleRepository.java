package com.expensetracker.repositories;

import com.expensetracker.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    UserRole findByRole(String role);
}
