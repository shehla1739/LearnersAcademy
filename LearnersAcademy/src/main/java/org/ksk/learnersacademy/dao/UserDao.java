package org.ksk.learnersacademy.dao;

import org.ksk.learnersacademy.entities.User;

public interface UserDao {
	void insert(User user);
	User get(String username, String password);
	//void update(User user);
}
