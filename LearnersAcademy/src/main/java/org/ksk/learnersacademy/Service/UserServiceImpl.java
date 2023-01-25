package org.ksk.learnersacademy.Service;

import org.ksk.learnersacademy.dao.UserDao;
import org.ksk.learnersacademy.dao.UserDaoImpl;
import org.ksk.learnersacademy.entities.User;

public class UserServiceImpl implements UserService {

	UserDao userDao=new UserDaoImpl();
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public User get(String username, String password) {		
		return userDao.get(username, password);
	}
/*
	@Override
	public void updatePassword(String user, String password, String newPassword) {
		User user=userDao.get(user, password);
		user.setPassword(newPassword);	
		userdao.update(user)	
	}
*/
	

}
