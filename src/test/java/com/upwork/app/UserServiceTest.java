package com.upwork.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.upwork.app.model.User;
import com.upwork.app.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUserName("Parth");
		user.setPassword("password");
		userService.create(user);

		User createdUser = userService.getUserById(user.getUserId());
		assertNotNull(createdUser);
		assertEquals("Parth", createdUser.getUserName());
	}

	@Test
	public void testLogin() {
		User user = new User();
		user.setUserName("admin");
		user.setPassword("admin");
		User existingUser = userService.checkLogin(user);
		assertNotNull(existingUser);
	}
}
