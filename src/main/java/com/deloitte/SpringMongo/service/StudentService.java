package com.deloitte.SpringMongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.deloitte.SpringMongo.controller.CustomException;
import com.deloitte.SpringMongo.entity.Student;
import com.deloitte.SpringMongo.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public Student createStudent (Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudentbyId(String id) throws CustomException{
		Student student = studentRepository.findStudentById(id);
		if(student!=null) {
			return student;
		}else {
			throw new CustomException("error hi error");
		}
	}
	
//	public Student getStudentbyId(String id) {
//		return studentRepository.findById(id).get();
//	}

	
	
	public Student updateStudent (Student student) {
		return studentRepository.save(student);
	}
	
	public String deleteStudent (String id) {
		studentRepository.deleteById(id);
		return "Student has been deleted.";
	}
	
	public List<Student> getStudentsByName (String name) {
		return studentRepository.findByName(name);
	}
	
//	public List<Student> getStudentsByName (String name) {
//		return studentRepository.getByName(name);
//	}

//	
    
//	public List<Student> studentsByNameAndMail(String name, String email) {
//		return studentRepository.getByNameAndEmail(name , email);
//	}
	
	
	
//	public List<Student> studentsByNameOrMail (String name, String email) {
//		return studentRepository.findByNameOrEmail(name, email);
//	}
	
//	public List<Student> getAllWithPagination (int pageNo, int pageSize) {
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//		
//		return studentRepository.findAll(pageable).getContent();
//	}
	
//	public List<Student> allWithSorting () {
//		Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");
//		
//		return studentRepository.findAll(sort);		
//	}
	
	public List<Student> byDepartmentName (String deptName) {
		return studentRepository.findByDepartmentDepartmentName(deptName);
	}
	
	public List<Student> bySubjectName (String subName) {
		return studentRepository.findBySubjectsSubjectName(subName);
	}
	
	public List<Student> emailLike (String email) {
		return studentRepository.findByEmailIsLike(email);
	}
	
//	public List<Student> nameStartsWith (String name) {
//		return studentRepository.findByNameStartsWith(name);
//	}
	
	public List<Student> nameStartsWith (String name) {
		return studentRepository.getByNameStartsWith(name);
	}
	
	public List<Student> getAllStudents() throws Exception {
		
		return studentRepository.findAll();
	}

//	public List<Student> getAllStudents() {
//		
//		return studentRepository.getAll();
//	}
	
	public List<Student> studentsByNameAndMail(String name, String email) {
		return studentRepository.getByNameAndEmail(name , email); 
	}

//	public List<Student> studentsByNameAndMail(String name, String email) {
//		return studentRepository.findByNameAndEmail(name , email); 
//	}
	
	public List<Student> studentsByNameOrMail (String name, String email) {
		return studentRepository.getByNameOrEmail(name, email);
	}


}
