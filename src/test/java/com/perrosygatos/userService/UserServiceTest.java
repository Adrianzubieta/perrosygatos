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

}
