package com.project.controller;

import com.project.model.Mobile;
import com.project.repository.MobilePhoneRepository;
import com.project.service.XMLTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@RestController
@RequestMapping("/xml")
public class XMLTestController {

    @Autowired
    private XMLTestService xmlTestService;

    @GetMapping("/list")
    public List getListOfCountry(){
        return xmlTestService.getListFromCountry();
    }

    @GetMapping("/set")
    public Set getSetOfCountry(){
        return xmlTestService.getSetFromCountry();
    }

    @GetMapping("/map")
    public Map getMapFromCounty(){
        return xmlTestService.getMapFromCountry();
    }

    @GetMapping("/prop")
    public Properties getPropFromCounty(){
        return xmlTestService.getPropFromCountry();
    }
}
