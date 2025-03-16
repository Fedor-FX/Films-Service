package com.example.filmservice.service;

import com.example.filmservice.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(int id);

    User addUser(User user);

    User updateUser(int id, User updatedUser);

    void deleteUser(int id);

    List<User> getAllUsers();
}
