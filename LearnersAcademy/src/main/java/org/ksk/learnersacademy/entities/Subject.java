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
import javax.persistence.ManyToOne;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	@ManyToOne
	//set relationship 
	private Teacher teacher;
	
	@ManyToMany(cascade = CascadeType.ALL)  //Owning Side of M:M Student:Class
	@JoinTable(name="Subject_Class", 
	joinColumns=@JoinColumn(name="sid"),
	inverseJoinColumns=@JoinColumn(name="cid"))
	private Set<AcademicClass> classes=new HashSet<>();  //reference to be used on other side of Join
	
		
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	//helper methods
	public void addClass(AcademicClass academicClass) {
		classes.add(academicClass);
	}
	public void removeClass(AcademicClass academicClass) {
		classes.remove(academicClass);
	}
}
