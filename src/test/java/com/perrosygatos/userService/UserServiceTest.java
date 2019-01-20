package com.perrosygatos.userService;

import com.perrosygatos.BaseTest;
import com.perrosygatos.user.domain.User;
import com.perrosygatos.user.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest extends BaseTest {

  @Autowired
  private UserService userService;

  @Test
  public void findById_withExistingId_returnUser() {
    Long id = 1L;

    User user = userService.findById(id);

    assertThat(user).isNotNull();
    assertThat(user.getId()).isEqualTo(1L);
    assertThat(user.getUserName()).isEqualTo("Adrian");
    assertThat(user.getEmail()).isEqualTo("AdrianZubieta@gmail.com");
    assertThat(user.getPassword()).isEqualTo("password-1");
  }

  @Test(expected = NoSuchElementException.class)
  public void findById_withNonExistentId_throwNoSuchElementException() {
    Long id = 99L;

    userService.findById(id);
  }

  @Test(expected = IllegalArgumentException.class)
  public void findById_withNull__throwsIllegalArgumentException() {
    userService.findById(null);
  }

  @Test
  public void findAll_withPageZeroSizeTwo_returnPageOfUsers() {
    Pageable pageable = PageRequest.of(0,2);

    Page<User> users = userService.findAll(pageable);

    assertThat(users.getTotalPages()).isEqualTo(2);
    assertThat(users.getContent().size()).isEqualTo(2);
    assertThat(users.getContent().get(0).getUserName()).isEqualTo("Adrian");
  }

  @Test(expected = IllegalArgumentException.class)
  public void findAll_withNull_throwIllegalArgumentException() {
    userService.findAll(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void findAll_withPageZeroSizeZero_throwIllegalArgumentException() {
    Pageable pageable = PageRequest.of(0,0);

    userService.findAll(pageable);
  }

  @Test
  public void save_withUserValid_returnUserSaved() {
    User user = new User();
    user.setUserName("user to save");
    user.setEmail("user@gmail.com");
    user.setPassword("password-user");

    User userSaved = userService.save(user);

    assertThat(userSaved).isNotNull();
    assertThat(userSaved.getId()).isEqualTo(5L);
    assertThat(user.getUserName()).isEqualTo("user to save");
    assertThat(user.getEmail()).isEqualTo("user@gmail.com");
    assertThat(user.getPassword()).isEqualTo("password-user");
  }

  @Test(expected = IllegalArgumentException.class)
  public void save_withUserNull_throwIllegalArgumentException() {
    userService.save(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void save_withUserWithEmailNull_throwIllegalArgumentException() {
    User user = new User();
    user.setUserName("user to save");
    user.setPassword("password-user");

    userService.save(user);
  }

  @Test(expected = IllegalArgumentException.class)
  public void save_withUserWithPasswordNull_throwIllegalArgumentException() {
    User user = new User();
    user.setUserName("user to save");
    user.setPassword("password-user");

    userService.save(user);
  }
}
