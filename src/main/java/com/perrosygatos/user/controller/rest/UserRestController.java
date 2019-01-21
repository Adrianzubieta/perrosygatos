package com.perrosygatos.user.controller.rest;

import com.perrosygatos.user.domain.User;
import com.perrosygatos.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {

  private final UserService userService;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id){
    return userService.findById(id);
  }

  @GetMapping
  public Page<User> findAll(Pageable pageable){
    return userService.findAll(pageable);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User save(@RequestBody User user){
    return userService.save(user);
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
