package org.ksk.learnersacademy.Service;

import org.ksk.learnersacademy.entities.User;

public interface UserService {
	void insert(User user);
	User get(String username, String password);
	//void updatePassword(String user,String password,String newPassword); 
}
