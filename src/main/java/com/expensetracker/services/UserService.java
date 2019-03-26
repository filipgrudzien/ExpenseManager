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

    private boolean creatorStatus = false;

    public List<User> getAllUsers() {
        return (userRepository.findAll());
    }

    public void insertOrUpdatePerson(User user) {
        setCreatorStatus(true);
        userRepository.save(user);
    }

    public boolean findUserWithSpecificEmail(String email) {
        if (userRepository == null) {
            return true;
        }
        if (userRepository.findByEmail(email) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean findUserWithSpecificLogin(String login) {
        if (userRepository == null) {
            return true;
        }
        if (userRepository.findByLogin(login) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getCreatorStatus(){
        return this.creatorStatus;
    }

    public void setCreatorStatus(boolean value){
        this.creatorStatus = value;
    }
}
