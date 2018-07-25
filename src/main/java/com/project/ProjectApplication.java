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
        Mobile mobile1 = new Mobile.Builder()
                .manufacture("Samsung")
                .mobileType("S7")
                .desc("csoda")
                .releaseDate("2017")
                .build();

        Mobile mobile2 = new Mobile.Builder()
                .manufacture("Apple")
                .mobileType("x")
                .desc("ezisaz")
                .releaseDate("2017")
                .build();

        Mobile mobile3 = new Mobile.Builder()
                .manufacture("Samsung")
                .mobileType("S8")
                .desc("dsadsad")
                .releaseDate("2015")
                .build();

        Mobile mobile4 = new Mobile.Builder()
                .mobileType("S8")
                .releaseDate("2015")
                .build();

        mobilePhoneRepository.save(mobile1);
        mobilePhoneRepository.save(mobile2);
        mobilePhoneRepository.save(mobile3);
        mobilePhoneRepository.save(mobile4);
    }
}
