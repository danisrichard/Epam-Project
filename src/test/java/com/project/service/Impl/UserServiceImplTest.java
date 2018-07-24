package com.project.service.Impl;

import com.project.model.User;
import com.project.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
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
    public void testgetAllUser() {
    }

    @Test
    public void testaddNewUserShouldAddToUserRepoWhenValidUserIsValid() {
        User validUser = Mockito.mock(User.class);
        validUser.setFirstName("Test");
        validUser.setSecondName("Test");

        when(userRepository.save(any(User.class))).thenReturn(new User());

        assertThat(userService.addNewUser(user),is(notNullValue()));
    }

    @Test
    public void testfindUserByFirstNameQuery() {
    }

    @Test
    public void testfindUserByFirstNameWithoutQueryShouldReturnListWithTwoUserWhenSearchToA() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1,user,user2));
        List<User> userList = userService.findUserByFirstNameWithoutQuery("A");

        assertNotNull(userList);
        assertEquals(2,userList.size());
    }

    @Test
    public void testfindUserByFirstNameWithoutQueryShouldReturnListWithoutResultWhenInputIsNull() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1,user,user2));
        List<User> userList = userService.findUserByFirstNameWithoutQuery(null);

        assertTrue(userList.isEmpty());
    }

    @Test
    public void testfindUserByFirstNameWithoutQueryShouldReturnListWithoutResultWhenInputIsDButItsNotRepresent(){
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1,user,user2));
        List<User> userList = userService.findUserByFirstNameWithoutQuery("D");

        assertTrue(userList.isEmpty());
    }
}