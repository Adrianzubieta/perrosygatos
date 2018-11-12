package com.perrosygatos.UserServiceTest;

import com.perrosygatos.PerrosygatosApplication;
import com.perrosygatos.domain.User;
import com.perrosygatos.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PerrosygatosApplication.class)
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findById_withExistingId_returnUser() {
        Long id = 1L;

        User user = userService.findById(id);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(id);
    }

    @Test(expected = NoSuchElementException.class)
    public void findById_withNonExistentId_throwException() {
        Long id = 9999L;

        userService.findById(id);
    }

    @Test(expected = NoSuchElementException.class)
    public void findById_withNull__throwsEception() {
        userService.findById(null);
    }

    @Test
    public void findAll_withFourExisting_returnListUser() {

        List<User> users = userService.findAll();

        assertThat(users.size()).isEqualTo(4);
    }
}
