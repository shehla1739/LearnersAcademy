package org.ksk.learnersacademy.dao;

import java.util.List;

import org.ksk.learnersacademy.entities.Teacher;

public interface TeacherDao {
	Teacher get(int tid);
	List<Teacher> getAll();
	void insert(Teacher teacher);
	void delete(Teacher teacher);
	void update(Teacher teacher);
}
