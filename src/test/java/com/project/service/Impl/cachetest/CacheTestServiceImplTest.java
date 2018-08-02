package com.project.service.Impl.cachetest;

import com.project.model.cachetest.Product;
import com.project.model.cinemaproject.maintenance.Pro;
import com.project.service.CacheTestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CacheTestServiceImplTest {

    private CacheTestService cacheTestService;

    @Mock
    private Product product;

    @Before
    public void setUp(){
        cacheTestService = new CacheTestServiceImpl();
    }

    @Test
    public void setNewNameForProduct() {
        Product product1 = cacheTestService.setNewNameForProduct(product);
        when(product1.getName()).thenReturn("dsadsa");

        assertEquals(product1.getName(), "dsadsa");
    }
}