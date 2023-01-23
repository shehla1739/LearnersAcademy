package org.ksk.learnersacademy.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class AcademicClass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String name;
	private String duration;
	
	@ManyToMany(mappedBy="classes", cascade=CascadeType.ALL)   //non-owning side of M:M Student:Class, use mappedBy reference from owning side
	private Set<Subject> subjects=new HashSet<>(); 
	
	@OneToMany
	//setup relationship
	private Set<Student> students=new HashSet<>();
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	//helper methods
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
	public void removeSubject(Subject subject) {
		subjects.remove(subject);
	}
	public void addStudent(Student student) {
		students.add(student);
	}
	public void removeStudent(Student student) {
		students.remove(student);
	}
	
	
}
