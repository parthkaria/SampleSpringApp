package com.upwork.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.upwork.app.model.User;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(User user) {
		entityManager.persist(user);
	}

	public void update(User user) {
		entityManager.merge(user);
	}

	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}

	public void delete(int id) {
		User user = getUserById(id);
		if (user != null) {
			entityManager.remove(user);
		}
	}

	public User checkLogin(User user) {
		Query query = entityManager.createQuery("from User where userName = :username");
		query.setParameter("username", user.getUserName());
		List userList = query.getResultList();
		if (userList.isEmpty()) {
			return null;
		} else {
			return (User) userList.get(0);
		}
	}
}
