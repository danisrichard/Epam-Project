package com.project.service.Impl;

import com.project.model.Mobile;
import com.project.model.ResponseMobile;
import com.project.repository.MobilePhoneRepository;
import com.project.service.WeatherAppService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneFinderServiceImplTest {

    private static final Logger logger = LogManager.getLogger(PhoneFinderServiceImplTest.class);

    @InjectMocks
    private PhoneFinderServiceImpl phoneFinderService;

    @Mock
    private MessageSource messageSource;

    @Mock
    private MobilePhoneRepository mobilePhoneRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPhoneMessageWhenReturnValidMobileIDShouldReturnResponseMobileBuilder() {
        when(mobilePhoneRepository.findById(2L)).thenReturn(Optional.of(new Mobile("Samsung", "S8", "Lorem ipsum", "2011")));
        when(messageSource.getMessage("manufacture",new Object[]{"Samsung"},Locale.ENGLISH)).thenReturn("Manufacture: Samsung");
        when(messageSource.getMessage("manufacture",new Object[]{"Samsung"},Locale.ENGLISH)).thenReturn("Manufacture: Samsung");


        ResponseMobile responseMobile = phoneFinderService.getPhoneMessage(2L);

        assertNotNull(responseMobile);
        assertEquals("Manufacture: Samsung null null null",responseMobile.getSentenceValue());
    }


}