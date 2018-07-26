package com.project.controller;

import com.project.error.NotFoundThisMobileException;
import com.project.service.MobileFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;


@Controller
@RequestMapping("/mobile")
@SessionScope
public class MobileFinderController {

    @Autowired
    private MobileFinderService mobileFinderService;

    @GetMapping("/get/{id}")
    public String getMobilePhone(Model model, @PathVariable Long id) throws NotFoundThisMobileException {
        try {
            model.addAttribute("phone", mobileFinderService.getPhoneMessage(id));
        }catch (Exception e){
            throw new NotFoundThisMobileException();
        }
        return "mobile-section/mobile-index";
    }
}
