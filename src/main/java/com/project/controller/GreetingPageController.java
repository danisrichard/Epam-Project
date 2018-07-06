package com.project.controller;


import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class GreetingPageController {

    @GetMapping(value = {"/", "/home"})
    public String homePageLoad(Model model, HttpSession httpSession) {
        //return a value to view, and you can refer to with 'helloworld'
        model.addAttribute("helloworld", "Hello Epam! :)");
        if (httpSession.getAttribute("inSession") != null) {
            model.addAttribute(httpSession.getAttribute("inSession"));
        }
        return "index";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greetingPageLoad(Model model, @RequestParam(value = "name", required = false, defaultValue = "EPAM") String nameValue) {
        model.addAttribute("nameValue", nameValue);
        return "greeting";
    }

    @GetMapping(value = "/session")
    public String loadSessionPage() {
        return "session";
    }

    @RequestMapping(value = "/add-to-session")
    public String addToSession(@RequestParam(value = "inputValue", required = false) String inputValue, HttpSession httpSession) {
        httpSession.setAttribute("inSession", inputValue);
        return "session";
    }
}