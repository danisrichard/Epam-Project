package com.project.service.Impl;

import com.project.service.XMLTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class XMLTestServiceImplTest {

//    UNIT TEST

    @Autowired
    private XMLTestService xmlTestService;

    @Test
    public void getListFromCountryShouldNotNullWhenReturnIt() {
        assertNotNull(xmlTestService.getListFromCountry());
    }

    @Test
    public void getMapFromCountryShouldNotNullWhenReturnIt() {
        assertNotNull(xmlTestService.getMapFromCountry());
    }

    @Test
    public void getSetFromCountryShouldNotNullWhenReturnIt() {
        assertNotNull(xmlTestService.getSetFromCountry());
    }

    @Test
    public void getPropFromCountryShouldNotNullWhenReturnIt() {
        assertNotNull(xmlTestService.getPropFromCountry());
    }
}