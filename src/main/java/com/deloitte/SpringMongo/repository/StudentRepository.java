package com.deloitte.SpringMongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.SpringMongo.entity.Student;

@Repository
public interface StudentRepository  extends MongoRepository<Student,String>{
	
    List<Student> findByName(String name);
	
//	List<Student> findByNameAndEmail (String name , String email);
	
	List<Student> findByNameOrEmail (String name, String email);
	
	List<Student> findByDepartmentDepartmentName(String deptname);
	
	List<Student> findBySubjectsSubjectName (String subName);
	
	List<Student> findByEmailIsLike (String email);
	
//	List<Student> findByNameStartsWith (String name);
	
	@Query("{name : ?0}")   
	List<Student> getByNameStartsWith (String name);
	
	@Query("{_id:'?0'}")
    Student findStudentById(String _id);
	
//	@Query("{\"name\" : \"?0\"}")
//	List<Student> getByName(String name);
	
//	@Query("{ $and : [ { \"name\" : \"?0\" }, { \"email\" : \"?1\" } ] }")
//    List<Student> getByNameAndEmail(String name , String email );
	
	@Query("{'name' : ?0, 'email' : ?1}")
	List<Student> getByNameAndEmail(String name , String email);
//	
//	@Query("{\"name\" : \"?0\"}, {\"email\" : \"?1\"}")
//	List<Student> getByNameAndEmail(String name, String email);
	
//	@Query("{'active':true}")
//	List<Student> getAll();
	
//	@Query("{'name' : ?0, 'email' : ?1}")
//	List<Student> getByNameOrEmail(String name , String email);
	
	@Query("{$or :[{name : ?0},{email: ?1}]}")
	List<Student> getByNameOrEmail(String name , String email);
	

}
