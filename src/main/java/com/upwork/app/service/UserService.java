package com.upwork.app.service;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upwork.app.dao.UserDao;
import com.upwork.app.model.User;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void create(User user) {
		userDao.create(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public User checkLogin(User user) {
		return userDao.checkLogin(user);
	}
}
