package com.project.service.Impl;

import com.project.entity.User;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    // ez még mindig elhasal nincs UserRepo!

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init(){
        User user = new User();
        user.setFirstName("BlaBla");
        user.setSecondName("BlaBla2");

        userRepository.save(user);
    }

    @Test
    public void getAllUser() {
        Iterable<User> listOfUser = userService.getAllUser();
         String userFirstName = StreamSupport.stream(listOfUser.spliterator(),false)
                                                    .map(User::getFirstName)
                                                    .findFirst().get();

         assertEquals(userFirstName,"BlaBla");
    }

    @Test
     void addNewUser() {
    }

    @Test
     void findUserByFirstNameQuery() {
    }

    @Test
     void findUserByFirstNameWithoutQuery() {
    }
}