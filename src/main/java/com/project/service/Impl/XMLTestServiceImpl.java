package com.project.service.Impl;

import com.project.model.xmltest.BeanXMLTest;
import com.project.service.XMLTestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@ImportResource("classpath:xmlTest.xml")
public class XMLTestServiceImpl implements XMLTestService {

    @Autowired
    private BeanXMLTest beanXMLTest;

    private static final Logger logger = LogManager.getLogger(XMLTestServiceImpl.class);

    @Override
    public List getListFromCountry() {
        List addressList = beanXMLTest.getAddressList();
        logger.info(Arrays.toString(addressList.toArray()));
        return addressList;
    }

    @Override
    public Map getMapFromCountry() {
        return beanXMLTest.getAddressMap();
    }

    @Override
    public Set getSetFromCountry() {
        return beanXMLTest.getAddressSet();
    }

    @Override
    public Properties getPropFromCountry() {
        return beanXMLTest.getAddressProp();
    }
}
