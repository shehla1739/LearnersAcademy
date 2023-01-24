package org.ksk.learnersacademy.dao;

import java.util.List;

import org.ksk.learnersacademy.entities.Subject;

public interface SubjectDao {
	Subject get(int sid);
	List<Subject> getAll();
	void insert(Subject subject);
	void delete(Subject subject);
	void update(Subject subject);
}
