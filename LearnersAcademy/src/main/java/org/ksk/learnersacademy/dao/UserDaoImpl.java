package org.ksk.learnersacademy.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ksk.learnersacademy.config.HibConfig;
import org.ksk.learnersacademy.entities.Teacher;
import org.ksk.learnersacademy.entities.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void insert(User user) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//save teacher object to db
			session.save(user);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}			
	}

	@Override
	public User get(String username, String password) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		
		Query<User> query=session.createQuery("select u fromorg.ksk.learnersacademy.entities.User u where u.username=?1 and u.password=?2");
		query.setParameter(1, username);
		query.setParameter(2,password); 
		
		return query.getSingleResult();
	}
/*
	@Override	
	public void update(User user) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			
			session.save(user);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}			
	}
*/

}
