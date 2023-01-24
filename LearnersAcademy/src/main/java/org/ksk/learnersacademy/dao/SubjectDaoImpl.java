package org.ksk.learnersacademy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ksk.learnersacademy.config.HibConfig;
import org.ksk.learnersacademy.entities.Subject;

public class SubjectDaoImpl implements SubjectDao{
	@Override
	public Subject get(int sid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		
		Subject subject=session.get(Subject.class, sid);  
		return subject;
	}


	@Override
	public List<Subject> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();

		Query<Subject> query=session.createQuery("select s from org.ksk.learnersacademy.entities.Subject s");
		return query.list();
	}

	@Override
	public void insert(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//save subject object to db
			session.save(subject);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();			
			session.delete(subject);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			// save/update subject object to db
			session.save(subject);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}


}
