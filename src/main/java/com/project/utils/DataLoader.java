package com.project.utils;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }


    /*
    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DataFactory dataFactory;

    private List<BusinessPerson> getDogList(){
        List<BusinessPerson> listOfPerson = new ArrayList<>();




        return listOfPerson;
    }

    @Override
    public void run(String... args) throws Exception {


    }
    */
}
