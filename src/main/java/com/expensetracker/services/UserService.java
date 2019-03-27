package com.expensetracker.services;

import com.expensetracker.repositories.UserRepository;
import com.expensetracker.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private boolean creatorStatus = false;

    public List<User> getAllUsers() {
        return (userRepository.findAll());
    }

    /// right now this function remain to add ADMIN
    /*public void insertOrUpdatePerson(User user) {
        setCreatorStatus(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        UserRole userRole = userRoleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<UserRole>(Arrays.asList(userRole)));
        userRepository.save(user);
    }*/

    public void insertOrUpdatePerson(User user) {
        setCreatorStatus(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(2);
        UserRole userRole = userRoleRepository.findByRole("USER");
        user.setRoles(new HashSet<UserRole>(Arrays.asList(userRole)));
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


    public User findUserByEmail(String email){
        return (userRepository.findByEmail(email));
    }

    public boolean getCreatorStatus(){
        return this.creatorStatus;
    }

    public void setCreatorStatus(boolean value){
        this.creatorStatus = value;
    }
}
