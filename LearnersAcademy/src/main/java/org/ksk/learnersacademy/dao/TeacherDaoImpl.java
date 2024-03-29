package org.ksk.learnersacademy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ksk.learnersacademy.config.HibConfig;
import org.ksk.learnersacademy.entities.Teacher;

public class TeacherDaoImpl implements TeacherDao{
	
	@Override
	public Teacher get(int tid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		
		Teacher teacher=session.get(Teacher.class, tid);  
		return teacher;
	}


	@Override
	public List<Teacher> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();

		Query<Teacher> query=session.createQuery("select t from org.ksk.learnersacademy.entities.Teacher t");
		return query.list();
	}

	@Override
	public void insert(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//save teacher object to db
			session.save(teacher);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();			
			session.delete(teacher);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			// save/update teacher object to db
			session.save(teacher);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	
}
