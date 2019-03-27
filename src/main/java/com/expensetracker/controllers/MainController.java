package com.expensetracker.controllers;

import com.expensetracker.entities.ActionStatus;
import com.expensetracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private ActionStatus actionStatus;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showMainPage(Model model) {
        if(userService.getCreatorStatus()==true){
            actionStatus.successfulUserCreation();
            userService.setCreatorStatus(false);
            model.addAttribute("status", actionStatus);
        }else{
            model.addAttribute("status", new ActionStatus());
        }
        return "index";
    }

    @RequestMapping("/login")
    public ModelAndView showLoginView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/admin/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getLogin() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    /*
    TO-DO: "Controller Layer
MVC Logic"
    https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d

    * */
}
