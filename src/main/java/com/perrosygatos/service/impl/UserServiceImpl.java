package com.perrosygatos.service.impl;

import com.perrosygatos.domain.Users;
import com.perrosygatos.repository.UserRepository;
import com.perrosygatos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).get();
    }
}
