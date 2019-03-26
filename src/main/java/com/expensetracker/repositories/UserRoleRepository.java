package com.expensetracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface UserRoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}
