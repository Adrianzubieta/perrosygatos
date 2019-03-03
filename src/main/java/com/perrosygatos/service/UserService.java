package com.perrosygatos.service;

import com.perrosygatos.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

  User findById(Long id);

  Page<User> findAll(Pageable pageable);

  User save(User user);

  User update(User user);

  void delete(Long id);
}
