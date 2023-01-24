package org.ksk.learnersacademy.dao;

import java.util.List;

import org.ksk.learnersacademy.entities.Student;

public interface StudentDao {
	Student get(int stdid);
	List<Student> getAll();
	void insert(Student student);
	void delete(Student student);
	void update(Student student);
}
