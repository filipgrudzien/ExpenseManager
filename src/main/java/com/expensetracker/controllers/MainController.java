package com.expensetracker.controllers;

import com.expensetracker.entities.ActionStatus;
import com.expensetracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
