package com.project.model.xmltest;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BeanXMLTest {
    private List addressList;
    private Set addressSet;
    private Map addressMap;
    private Properties addressProp;

    public void setAddressList(List addressList) {
        this.addressList = addressList;
    }

    public List getAddressList() {
        return addressList;
    }

    public void setAddressSet(Set addressSet) {
        this.addressSet = addressSet;
    }

    public Set getAddressSet() {
        return addressSet;
    }

    public void setAddressMap(Map addressMap) {
        this.addressMap = addressMap;
    }

    public Map getAddressMap() {
        return addressMap;
    }

    public void setAddressProp(Properties addressProp) {
        this.addressProp = addressProp;
    }

    public Properties getAddressProp() {
        return addressProp;
    }
}
