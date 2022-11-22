package com.deloitte.SpringMongo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.SpringMongo.entity.Student;
import com.deloitte.SpringMongo.repository.StudentRepository;
import com.deloitte.SpringMongo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	@Autowired
	StudentRepository studentRepo;
	
	List<Student> studentList;

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

//	@PostMapping("/create")
//	public ResponseEntity addStudent(@RequestBody Student student) {
//		
//		System.out.println(student);
//		if(studentsByName(student.getName())==null) {
//			return new ResponseEntity<Student>(studentRepo.save(student), HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>("user already exists",HttpStatus.BAD_REQUEST);
//		}
//		
//	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}
	
	
	
	
//	@GetMapping("/getById/{id}")
//	public Student getStudentbyId(@PathVariable String id) {
//		Student student = new Student();
//		
//		try {
//			student = studentService.getStudentbyId(id);
//			
//		} catch (CustomException e) {
//			// TODO Auto-generated catch block
//			
//			student.setName(e.getMessage());
//			return null;
////			return e.getMessage();
//			
//		}
//		
//		return student;
//		
//	}
	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity getStudentbyId(@PathVariable String id) {
		Student student = new Student();
		
		try {
			student = studentService.getStudentbyId(id);
			
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			
			student.setName(e.getMessage());
			return new ResponseEntity("Id not found",HttpStatus.BAD_REQUEST);
//			return e.getMessage();
			
		}
		logger.info("Get  studentsByName  for " + id);
		return new ResponseEntity<>(student,HttpStatus.OK);
		
	}

//	@GetMapping("/getById/{id}")
//	public Student getStudentbyId(@PathVariable String id) {
//		return studentService.getStudentbyId(id);
//	}
	
//	@GetMapping("/getById/{id}")
//	public Student getStudentbyId(@PathVariable String id) {
//		return studentService.getStudentbyId(id);
//	}

	@GetMapping("/all")
	public List<Student> getAllStudents() {
		
		Student student = new Student();
		try {
			return studentService.getAllStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			student.setName(e.getMessage());
		}
		List<Student> list = new ArrayList<>();
		list.add(student);
		return list;
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

//	@DeleteMapping("/delete/{id}")
//	public String deleteStudent(@PathVariable String id) {
//		return studentService.deleteStudent(id);
//	}

	@GetMapping("/studentsByName/{name}")
	public List<Student> studentsByName(@PathVariable String name) {
		//
		logger.info("Get  studentsByName  for " + name);
		return studentService.getStudentsByName(name);
	}

	@GetMapping("/studentsByNameAndMail/{name}/{email}")
	public List<Student> studentsByNameAndMail(@PathVariable String name, @PathVariable String email) {
		return studentService.studentsByNameAndMail(name, email);
	}

	@GetMapping("/studentsByNameOrMail/{name}/{email}")
	public List<Student> studentsByNameOrMail(@PathVariable String name, @PathVariable String email) {
		logger.info("Get  studentsByName  for " + name + email);
		return studentService.studentsByNameOrMail(name, email);
	}

//	@GetMapping("/allWithPagination")
//	public List<Student> getAllWithPagination(@RequestParam int pageNo,
//			@RequestParam int pageSize) {
//		return studentService.getAllWithPagination(pageNo, pageSize);
//	}
//	
//	@GetMapping("/allWithSorting")
//	public List<Student> allWithSorting() {
//		return studentService.allWithSorting();
//	}

	@GetMapping("/byDepartmentName")
	public List<Student> byDepartmentName(@RequestParam String deptName) {
		return studentService.byDepartmentName(deptName);
	}

	@GetMapping("/bySubjectName")
	public List<Student> bySubjectName(@RequestParam String subName) {
		return studentService.bySubjectName(subName);
	}

	@GetMapping("/emailLike")
	public List<Student> emailLike(@RequestParam String email) {
		return studentService.emailLike(email);
	}

	@GetMapping("/nameStartsWith")
	public List<Student> nameStartsWith(@RequestParam String name) {
		return studentService.nameStartsWith(name);
	}

}
