package com.perrosygatos.controller;

import com.perrosygatos.domain.User;
import com.perrosygatos.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

  private final UserService userService;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id){
    log.debug("Buscando user por Id: {}",id);
    User user = userService.findById(id);
    log.debug("Devuelvo user: {}",user);
    return user;
  }

  @GetMapping
  public Page<User> findAll(Pageable pageable){
    Page<User> users = userService.findAll(pageable);
    log.debug("devuelvo users: {}", users);
    return users;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User save(@RequestBody User user){
    User userSaved = userService.save(user);
    log.debug("Se guardo user: {}",user);
    return userSaved;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){
    userService.delete(id);
  }

  @PatchMapping
  public User update(@RequestBody User user){
    return userService.update(user);
  }

}
