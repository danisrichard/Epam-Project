package com.project.service.Impl;

import com.project.service.SimpleCalculator;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculatorImpl implements SimpleCalculator {

    @Override
    public int addTwoNumber(int a, int b) {
        return a+b;
    }
}
