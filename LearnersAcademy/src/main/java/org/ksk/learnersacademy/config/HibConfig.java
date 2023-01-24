package org.ksk.learnersacademy.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.ksk.learnersacademy.entities.AcademicClass;
import org.ksk.learnersacademy.entities.Student;
import org.ksk.learnersacademy.entities.Subject;
import org.ksk.learnersacademy.entities.Teacher;

public class HibConfig {
	public static SessionFactory getSessionFactory() {
		Configuration configuration=new Configuration();
		Properties properties=new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/learnersAcademydb");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(AcademicClass.class);
		configuration.addAnnotatedClass(Subject.class);
		
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		return sessionFactory;
	}
}
