package org.ksk.learnersacademy.dao;

import java.util.List;

import org.ksk.learnersacademy.entities.AcademicClass;

public interface AcademicClassDao {
	AcademicClass get(int cid);
	List<AcademicClass> getAll();
	void insert(AcademicClass academcClass);
	void delete(AcademicClass academcClass);
	void update(AcademicClass academcClass);
}
