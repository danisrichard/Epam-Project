package com.project.controller;

import com.project.model.Mobile;
import com.project.repository.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Locale;

@Controller
@RequestMapping("/mobile")
@SessionScope
public class MobileFinderController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    @GetMapping("/get/{id}")
    public String getMobilePhone(Model model,@PathVariable String id){

        Mobile mobile = mobilePhoneRepository.findById(id);

        model.addAttribute("phone",messageSource.getMessage("phone",new Object[] {mobile.getManufacture(),mobile.getMobileType(),mobile.getReleaseDate()}, Locale.ENGLISH));
        return "mobile-section/mobile-index";
    }
}
