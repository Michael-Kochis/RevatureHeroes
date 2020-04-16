package com.revature.test.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.revature.model.LoginForm;
import com.revature.model.User;
import com.revature.service.UserService;

public class UserServiceTest {
	public static UserService us = new UserService();
	public static MockHttpServletRequest request = new MockHttpServletRequest();
	public static MockHttpServletResponse response = new MockHttpServletResponse();
	public static LoginForm login = new LoginForm("mike", "pass");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		ResponseEntity<User> user = us.login(request, response, login);
		assertTrue(user.getBody().getUsername().equalsIgnoreCase("mike") );
	}

	@Test
	public void testLoginWrongPassword() {
		login.setPassword("qwerty");
		ResponseEntity<User> user = us.login(request, response, login);
		assertFalse(user.getBody().getUsername().equalsIgnoreCase("mike") );
	}

}
