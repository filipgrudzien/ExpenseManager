package com.expensetracker.controllers;

import com.expensetracker.entities.ActionStatus;
import com.expensetracker.entities.User;
import com.expensetracker.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/createacc")
    public String showUserCreatorView(Model model){
        model.addAttribute("user", new User());
        return "user-creator";
    }

    @RequestMapping("/submitacc")
    public String submitCreationForm(@Valid User user, Errors errors, Model model) {

        if(errors.hasErrors()){
            model.addAttribute("user", user);
            return "user-creator";
        }

        userService.insertOrUpdatePerson(user);

        return "redirect:/";
        // eventually might add bean class to control successful creation to display pop-up "user added successfully"
        // in that case, this method need to be type "ModelAndView"
    }

    @RequestMapping("/signin")
    public String showUserSignInView(){
        return "user-signin";
    }

    @RequestMapping("/showall")
    public String showAllUsersList(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }
}

/*
@RequestMapping("/submitacc")
    public String submitCreationForm(@Valid User user, Errors errors, Model model) {

        if(errors.hasErrors()){
            model.addAttribute("user", user);
            return "user-creator";
        }

        userService.insertOrUpdatePerson(user);

        return "redirect:/";
        // eventually might add bean class to control successful creation to display pop-up "user added successfully"
        // in that case, this method need to be type "ModelAndView"
    }
* */