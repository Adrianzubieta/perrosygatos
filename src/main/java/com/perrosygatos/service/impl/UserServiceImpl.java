package com.perrosygatos.service.impl;

import com.perrosygatos.domain.User;
import com.perrosygatos.repository.UserRepository;
import com.perrosygatos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public User findById(Long id) throws NoSuchElementException {
        if(id == null){
            throw new NoSuchElementException();
        }
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
