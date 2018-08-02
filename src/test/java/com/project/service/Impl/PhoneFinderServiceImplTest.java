package com.project.service.Impl;

import com.project.model.mobilesection.Mobile;
import com.project.model.mobilesection.ResponseMobile;
import com.project.repository.MobilePhoneRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhoneFinderServiceImplTest {

    private static final Logger logger = LogManager.getLogger(PhoneFinderServiceImplTest.class);

    @InjectMocks
    private PhoneFinderServiceImpl phoneFinderService;

    @Mock
    private MessageSource messageSource;

    @Mock
    private MobilePhoneRepository mobilePhoneRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPhoneMessageWhenReturnValidMobileIDShouldReturnResponseMobileBuilder() {
        when(mobilePhoneRepository.findById(2L)).thenReturn(Optional.of(new Mobile("Samsung", "S8", "Lorem ipsum", "2011")));
        when(messageSource.getMessage("manufacture", new Object[]{"Samsung"}, Locale.ENGLISH)).thenReturn("Manufacture: Samsung");
        when(messageSource.getMessage("manufacture", new Object[]{"Samsung"}, Locale.ENGLISH)).thenReturn("Manufacture: Samsung");

        ResponseMobile responseMobile = phoneFinderService.getPhoneMessage(2L);

        assertNotNull(responseMobile);
        assertEquals("Manufacture: Samsung null null null", responseMobile.getSentenceValue());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetPhoneMessageWhenGetInvalidPhoneNumberShouldThrowNewIllegalStateException() {
        when(mobilePhoneRepository.findById(2L)).thenReturn(Optional.empty());

        try {
            phoneFinderService.getPhoneMessage(2L);
        }catch (IllegalStateException e){
            System.out.println("dob");
        }

    }

}