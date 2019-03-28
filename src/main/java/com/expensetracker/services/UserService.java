package com.expensetracker.services;

import com.expensetracker.DTO.UserDTO;
import com.expensetracker.entities.Role;
import com.expensetracker.entities.User;
import com.expensetracker.repositories.UserRepository;
import com.expensetracker.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private boolean creatorStatus = false;

    public List<User> getAllUsers() {
        return (userRepository.findAll());
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserDTO accountDTO) throws EmailExistxception {

        if (emailExist(accountDTO.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + accountDTO.getEmail());
        }
        User user = new User();
        user.setLogin(accountDTO.getLogin());
        user.setPassword(accountDTO.getPassword());
        user.setEmail(accountDTO.getEmail());
        user.setRoles(Arrays.asList("ROLE_USER"));
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {

        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
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
        user.setEnabled(2);
        Role userRole = userRoleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
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


    public User findUserByEmail(String email) {
        return (userRepository.findByEmail(email));
    }

    public boolean getCreatorStatus() {
        return this.creatorStatus;
    }

    public void setCreatorStatus(boolean value) {
        this.creatorStatus = value;
    }
}
