package com.project.controller;

import com.project.service.SimpleCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private SimpleCalculator simpleCalculator;

    @RequestMapping("/calculate/{a}/{b}")
    public int calculatedNumber(@PathVariable("a") int a, @PathVariable("b") int b){
        return simpleCalculator.addTwoNumber(a,b);
    }
}
