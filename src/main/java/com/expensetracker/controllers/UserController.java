package com.expensetracker.controllers;

import com.expensetracker.DTO.UserDTO;
import com.expensetracker.entities.User;
import com.expensetracker.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    /*@RequestMapping("/createacc")
    public String showUserCreatorView(Model model){
        model.addAttribute("user", new User());
        return "user-creator";
    }

    @RequestMapping("/submitacc")
    public ModelAndView submitCreationForm(@Valid User user, Errors errors, Model model) {

        ModelAndView mav = new ModelAndView();

        if(errors.hasErrors()){
            mav.addObject("user", user);
            mav.setViewName("user-creator");
            return mav;
        }

        userService.insertOrUpdatePerson(user);
        mav.setViewName("redirect:/");
        return mav;
    }*/

    /// helper controller
    @RequestMapping("/showall")
    public String showAllUsersList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDTO accountDto,
             BindingResult result, WebRequest request, Errors errors) {

        User registered = new User();

        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }

        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }

        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            return new ModelAndView("successRegister", "user", accountDto);
        }
    }

    private User createUserAccount(UserDTO accountDto, BindingResult result) {

        User registered = null;

        try {
            registered = userService.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }

        return registered;
    }

}