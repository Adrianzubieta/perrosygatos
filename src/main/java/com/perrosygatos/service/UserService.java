package com.perrosygatos.service;

import com.perrosygatos.domain.Users;



public interface UserService {
    Users findById(Long id);
}
