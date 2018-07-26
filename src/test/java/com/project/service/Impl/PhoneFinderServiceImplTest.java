package com.project.service.Impl;

import com.project.repository.MobilePhoneRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneFinderServiceImplTest {

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

    }
}