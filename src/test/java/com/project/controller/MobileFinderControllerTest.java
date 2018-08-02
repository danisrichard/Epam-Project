package com.project.controller;

import com.project.error.NotFoundThisMobileException;
import com.project.model.error.ExceptionResponse;
import com.project.model.mobilesection.ResponseMobile;
import com.project.service.MobileFinderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class MobileFinderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MobileFinderService mobileFinderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMobilePhoneShouldReturnResponseMobileEntityWhenCallURLAndRepoHasGotItem() throws Exception {
        when(mobileFinderService.getPhoneMessage((long) 2)).thenReturn(new ResponseMobile.Builder()
                .titleValue("Samsung S5")
                .sentenceValue("Manufacture: Samsung Release Date: 2012 Type: S5 Desc: Lorem ipsum")
                .build());

        this.mockMvc.perform(get("/mobile/get/2"))
                .andExpect(view().name("mobile-section/mobile-index"))
                .andExpect(model().attribute("phone", hasItem(
                        allOf(
                                hasProperty("titleValue", is("Samsung S5")),
                                hasProperty("sentenceValue", is("Manufacture: Samsung Release Date: 2012 Type: S5 Desc: Lorem ipsum"))
                        )
                )));

        verify(mobileFinderService, times(1)).getPhoneMessage(2L);
        verifyNoMoreInteractions(mobileFinderService);
    }

    @Test
    public void testGetMobilePhoneShouldReturnPropertyErrorMessageWhenCallUrlWithInvalidValue() throws Exception {
        NotFoundThisMobileException notFoundThisMobileException = Mockito.mock(NotFoundThisMobileException.class);
        doThrow(notFoundThisMobileException).when(mobileFinderService.getPhoneMessage(10L));

        this.mockMvc.perform(get("/mobile/get/10"))
                .andExpect(view().name("mobile-section/mobile-index"))
                .andExpect(model().attribute("exception", hasItem(
                        hasProperty("sentenceValue", is("No value represent."))
                )));

        verify(mobileFinderService, times(1)).getPhoneMessage(10L);
        verifyNoMoreInteractions(mobileFinderService);
    }

}