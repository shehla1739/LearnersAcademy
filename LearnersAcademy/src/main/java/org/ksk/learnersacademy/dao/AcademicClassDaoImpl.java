package org.ksk.learnersacademy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.ksk.learnersacademy.config.HibConfig;
import org.ksk.learnersacademy.entities.AcademicClass;

public class AcademicClassDaoImpl implements AcademicClassDao{

	@Override
	public AcademicClass get(int cid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		
		AcademicClass academicClass=session.get(AcademicClass.class, cid);  
		return academicClass;
	}


	@Override
	public List<AcademicClass> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();

		Query<AcademicClass> query=session.createQuery("select c from org.ksk.learnersacademy.entities.AcademicClass cS");
		return query.list();
	}

	@Override
	public void insert(AcademicClass academicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//save academicClass object to db
			session.save(academicClass);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(AcademicClass academicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();			
			session.delete(academicClass);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(AcademicClass academicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session= factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			// save/update academicClass object to db
			session.save(academicClass);
			tx.commit();
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}
}
