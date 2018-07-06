package com.project.service.Impl;

import com.project.entity.User;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByFirstNameQuery(String firstName) {
        return null;
    }

    @Override
    public List<User> findUserByFirstNameWithoutQuery(String firstName) {
        Iterable<User> listOfAllUser = userRepository.findAll();
        return StreamSupport.stream(listOfAllUser.spliterator(),false)
                .filter(e -> e.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }
}
