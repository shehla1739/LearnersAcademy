package org.ksk.learnersacademy.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@JoinTable(name="Subject_Class", 
	joinColumns=@JoinColumn(name="cid"),
	inverseJoinColumns=@JoinColumn(name="sid"))
	private Set<Subject> subjects=new HashSet<>(); 
	
	@OneToMany(mappedBy="academicClass",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
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
		//subject.se
	}
	public void removeSubject(Subject subject) {
		subjects.remove(subject);
	}
	public void addStudent(Student student) {
		students.add(student);
		student.setAcademicClass(this);
	}
	public void removeStudent(Student student) {
		students.remove(student);
	}
	
	
}
