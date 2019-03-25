package com.expensetracker.constraints;

import com.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmail,String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueUserEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(userRepository == null){
            return true;
        }
        return userRepository.findByEmail(email) == null;
    }
}
