package com.expensetracker.repositories;

import com.expensetracker.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}
