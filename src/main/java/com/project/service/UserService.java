package com.project.service;


import com.project.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Iterable<User> getAllUser();

    void addNewUser(User user);

    Optional<User> findUserByFirstNameQuery(String firstName);

    List<User> findUserByFirstNameWithoutQuery(String firstName);

    void deleteUser(UUID id);
}