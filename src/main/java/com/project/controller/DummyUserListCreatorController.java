package com.project.controller;

import com.project.model.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class DummyUserListCreatorController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user-registration")
    public String loadUserRegSite(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", userService.getAllUser());
        return "user-registration";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String registerUser(@Valid User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            userService.addNewUser(user);
        }
        return "redirect:/user-registration";
    }

    @RequestMapping(value = "/delete-user/", method = RequestMethod.GET)
    public String deleteUser(@RequestParam(value = "id") UUID id) {
        userService.deleteUser(id);
        return "redirect:/user-registration";
    }
}
