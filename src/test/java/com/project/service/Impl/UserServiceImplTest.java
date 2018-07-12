package com.project.service.Impl;

import com.project.model.User;
import com.project.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    User user = new User();
    User user1 = new User();
    User user2 = new User();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        user.setFirstName("A");
        user.setSecondName("B");

        user1.setFirstName("C");
        user1.setSecondName("D");

        user2.setFirstName("A");
        user2.setSecondName("DSA");
    }


    @Test
    public void getAllUser() {
    }

    @Test
    public void addNewUser() {
    }

    @Test
    public void findUserByFirstNameQuery() {
    }

    @Test
    public void testfindUserByFirstNameWithoutQueryShouldReturnListWithTwoUserWhenSearchForA() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1,user,user2));

        List<User> userList = userService.findUserByFirstNameWithoutQuery("A");

        assertNotNull(userList);
        assertEquals(2,userList.size());
    }

    @Test
    public void deleteUser() {
    }
}