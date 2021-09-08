package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    User update(User user);

    User findById(Integer userId);

    void deleteById(Integer userId);

}