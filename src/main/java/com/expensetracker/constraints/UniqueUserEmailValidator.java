package com.expensetracker.constraints;

import com.expensetracker.repositories.UserRepository;
import com.expensetracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmail,String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueUserEmail constraintAnnotation) { }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (userService == null) {
            return true;
        }
        return userService.findUserWithSpecificEmail(email);
    }
}
