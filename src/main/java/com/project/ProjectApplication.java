package com.project;

import com.project.model.Mobile;
import com.project.repository.MobilePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

    @Autowired
    private MobilePhoneRepository mobilePhoneRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Mobile mobile1 = new Mobile("Samsung","S8","Lorem ipsum", "2011");
        Mobile mobile2 = new Mobile("Samsung","S5","Lorem ipsum", "2012");
        Mobile mobile3 = new Mobile("Samsung","S4","Lorem ipsum", "2013");
        Mobile mobile4 = new Mobile("Samsung","S7","Lorem ipsum", "2014");
        Mobile mobile5 = new Mobile("Samsung","S7","Lorem ipsum");


        mobilePhoneRepository.save(mobile1);
        mobilePhoneRepository.save(mobile2);
        mobilePhoneRepository.save(mobile3);
        mobilePhoneRepository.save(mobile4);
        mobilePhoneRepository.save(mobile5);

    }
}
