package org.ksk.learnersacademy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ksk.learnersacademy.config.HibConfig;
import org.ksk.learnersacademy.entities.Student;

public class StudentDaoImpl implements StudentDao{
	@Override
	public Student get(int stdid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		
		Student student=session.get(Student.class, stdid);  
		return student;
	}


	@Override
	public List<Student> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();

		Query<Student> query=session.createQuery("select s from org.ksk.learnersacademy.entities.Student s");
		return query.list();
	}

	@Override
	public void insert(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//save student object to db
			session.save(student);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();			
			session.delete(student);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			// save/update student object to db
			session.save(student);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}
}
