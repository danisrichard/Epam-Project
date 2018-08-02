package com.project.service.Impl;

import com.project.error.NotFoundThisMobileException;
import com.project.model.mobilesection.Mobile;
import com.project.model.mobilesection.ResponseMobile;
import com.project.repository.MobilePhoneRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PhoneFinderServiceImplTest {

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
    public void testGetPhoneMessageWhenAddValidMobileIDParameterShouldReturnResponseMobileBuilder() throws NotFoundThisMobileException {
        when(mobilePhoneRepository.findById(2L)).thenReturn(Optional.of(new Mobile("Samsung", "S5", "Lorem ipsum", "2012")));
        when(messageSource.getMessage("manufacture", new Object[]{"Samsung"}, Locale.ENGLISH)).thenReturn("Manufacture: Samsung");
        when(messageSource.getMessage("releaseDate", new Object[]{"2012"}, Locale.ENGLISH)).thenReturn("Release Date: 2012");
        when(messageSource.getMessage("desc", new Object[]{"Lorem ipsum"}, Locale.ENGLISH)).thenReturn("Desc: Lorem ipsum");
        when(messageSource.getMessage("type", new Object[]{"S5"}, Locale.ENGLISH)).thenReturn("Type: S5");

        ResponseMobile responseMobile = phoneFinderService.getPhoneMessage(2L);

        assertEquals("Manufacture: Samsung Release Date: 2012 Type: S5 Desc: Lorem ipsum", responseMobile.getSentenceValue());
    }

    @Test(expected = NotFoundThisMobileException.class)
    public void testGetPhoneMessageWhenAddInvalidPhoneIdParameterShouldThrowNewNotFoundThisMobileException() throws NotFoundThisMobileException {
        when(mobilePhoneRepository.findById(10L).orElseThrow(NotFoundThisMobileException::new)).thenThrow(new NotFoundThisMobileException());
        phoneFinderService.getPhoneMessage(10L);
    }

    @Test
    public void testGetPhoneMessageWhenAddValidMobileIDParameterAndEntityFieldsIsNullShouldReturnResponseMobileBuilder() throws NotFoundThisMobileException {
        when(mobilePhoneRepository.findById(2L)).thenReturn(Optional.of(new Mobile(null, null, null, null)));
        when(messageSource.getMessage("manufacture", new Object[]{""}, Locale.ENGLISH)).thenReturn("Manufacture: ");
        when(messageSource.getMessage("releaseDate", new Object[]{""}, Locale.ENGLISH)).thenReturn("Release Date: ");
        when(messageSource.getMessage("desc", new Object[]{""}, Locale.ENGLISH)).thenReturn("Desc: ");
        when(messageSource.getMessage("type", new Object[]{""}, Locale.ENGLISH)).thenReturn("Type: ");

        ResponseMobile responseMobile = phoneFinderService.getPhoneMessage(2L);

        assertEquals("Manufacture:ReleaseDate:Type:Desc:", StringUtils.deleteWhitespace(responseMobile.getSentenceValue()));
    }
}