package com.expensetracker.services;

import com.expensetracker.entities.User;
import com.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void insertOrUpdatePerson(User user){
        System.out.println(user);
        userRepository.save(user);
    }

    public boolean findUserWithSpecificEmail(String email){
        if(this.userRepository.findByEmail(email)==null){
            return true;
        }else{
            return false;
        }
    }
    public boolean findUserWithSpecificLogin(String login){
        if(this.userRepository.findByLogin(login)==null){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkIfUserRepositoryIsNull(){
        if(this.userRepository == null){
            return true;
        }else{
            return false;
        }
    }

    public int getAllUsersNumber(){
        return userRepository.findAll().size();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
