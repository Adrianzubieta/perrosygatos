package com.perrosygatos.user.service.impl;

import com.perrosygatos.user.domain.User;
import com.perrosygatos.user.repository.UserRepository;
import com.perrosygatos.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Override
  public User findById(Long id) {
    Assert.notNull(id, "El Id no puede ser null");
    return userRepository.findById(id).get();
  }

  @Override
  public Page<User> findAll(Pageable pageable) {
    Assert.notNull(pageable, "El paginado no puede ser vacio");
    return userRepository.findAll(pageable);
  }

  @Override
  @Transactional
  public User save(User user) {
    Assert.notNull(user, "El usuario no puede ser vacio");
    Assert.notNull(user.getEmail(), "El email no puede ser vacio");
    Assert.notNull(user.getPassword(), "El password no puede ser vacio");
    return userRepository.save(user);
  }

  @Override
  @Transactional
  public User update(User user) {
    Assert.notNull(user, "El usuario no puede ser vacio");
    Assert.hasText(user.getUserName(), "El userName no puede ser vacio");
    User userToUpdate = findById(user.getId());
    modelMapper.map(user, userToUpdate);
    return userToUpdate;
  }

  @Override
  public void delete(Long id) {
    Assert.notNull(id,"El id no puede ser vacio");
    try {
      userRepository.deleteById(id);
    }catch (EmptyResultDataAccessException ex){
      throw new NoSuchElementException();
    }

  }
}
