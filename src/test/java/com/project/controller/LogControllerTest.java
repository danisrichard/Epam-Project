package com.project.controller;

import com.project.utils.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LogControllerTest {

    @Autowired
    private LogUtils logUtils;

    @Test
    public void getLogLevelByPackage() {
        String getLevelValue = logUtils.getLevelInformationInJson("org.springframwork");

        String jsonValidValue = "{\"packageName\":\"org.springframwork\",\"levelName\":\"INFO\"}";

        assertEquals(getLevelValue,jsonValidValue);

    }

    @Test
    public void setLogLevelToPackage() {
    }
}