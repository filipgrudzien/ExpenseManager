package com.expensetracker.constraints;

import com.expensetracker.repositories.UserRepository;
import com.expensetracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserLoginValidator implements ConstraintValidator<UniqueUserLogin,String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueUserLogin constraintAnnotation) {

    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext context) {
        if(userService.checkIfUserRepositoryIsNull() == true){
            return true;
        }

        if(userService.findUserWithSpecificLogin(login) == true){
            return true;
        } else {
            return false;
        }
    }
}
