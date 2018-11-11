package com.perrosygatos.UserServiceTest;

import com.perrosygatos.PerrosygatosApplication;
import com.perrosygatos.domain.Users;
import com.perrosygatos.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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

	    Users user = userService.findById(id);

	    assertThat(user).isNotNull();
	    assertThat(user.getId()).isEqualTo(id);
	}

}
