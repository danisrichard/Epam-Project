package com.project.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@SpringBootTest
@PrepareForTest(LogUtils.class)
public class LogUtilsTest {

    @InjectMocks
    LogUtils logUtils;



    @Test
    public void testgetLevelInformationInJsonShouldReturnLevelInformationInJsonFormatWhenUseValidInput() {


    }

    @Test
    public void setCustomLogLevel() {
    }
}