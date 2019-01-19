package com.perrosygatos.user.service.impl;

import com.perrosygatos.user.domain.User;
import com.perrosygatos.user.repository.UserRepository;
import com.perrosygatos.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User findById(Long id){
    Assert.notNull(id,"El Id no puede ser null");
    return userRepository.findById(id).get();
  }

  @Override
  public Page<User> findAll(Pageable pageable) {
    return userRepository.findAll(pageable);
  }
}
