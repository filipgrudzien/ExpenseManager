package com.expensetracker.constraints;

import com.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserLoginValidator implements ConstraintValidator<UniqueUserLogin,String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueUserLogin constraintAnnotation) {

    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext context) {
        if(userRepository == null){
            return true;
        }
        return userRepository.findByLogin(login) == null;
    }
}
