package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;

import java.util.List;

public interface UserDao {
    List<User> getusers();

    void deleteUser(Long id);

    void registerUser(User user);

    User obtainUser(User user);
}
