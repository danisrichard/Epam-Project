package com.project.service.Impl;

import com.project.model.User;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(value = {"ADDRESS"}, key = "#user.address")
    public String getAddress(User user) {
        return userRepository.findById(user.getId()).map(User::getAddress).orElse("Not address for this user.");
    }

    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByFirstNameQuery(String firstName) {
        return Optional.empty();
    }

    @Override
    public List<User> findUserByFirstNameWithoutQuery(String firstName) {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(e -> e.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.delete(userRepository.findById(id).get());
    }
}
