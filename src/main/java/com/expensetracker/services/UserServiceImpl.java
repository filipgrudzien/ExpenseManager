package com.expensetracker.services;

import com.expensetracker.DTO.UserDTO;
import com.expensetracker.entities.User;

public interface UserServiceImpl {

    User registerNewUserAccount(UserDTO accountDto) throws EmailExistsException;
}
