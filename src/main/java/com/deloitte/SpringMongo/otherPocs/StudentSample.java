package com.deloitte.SpringMongo.otherPocs;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.deloitte.SpringMongo.entity.Department;
import com.deloitte.SpringMongo.entity.Subject;


public class StudentSample {

	private String name ;
	private int marks ;
	private String subject ;
	private int rollno ;
	public StudentSample(String name, int marks, String subject, int rollno) {
		super();
		this.name = name;
		this.marks = marks;
		this.subject = subject;
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", subject=" + subject + ", rollno=" + rollno + "]";
	}
	
	
	
	
	


}
