package com.perrosygatos.service;

import com.perrosygatos.domain.User;

import java.util.List;


public interface UserService {
    User findById(Long id);

    List<User> findAll();
}
