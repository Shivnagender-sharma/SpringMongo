package com.deloitte.SpringMongo.otherPocs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamFeature {
	

	private static final Object Abhishek = null;
	private static final Object Aryan = null;

	public static void main(String[] args) {
		
		StudentSample StudentSample1 = new StudentSample("Abhishek", 70, "Maths",1 ) ;
		StudentSample StudentSample2 = new StudentSample("Aryan", 60, "English",2 ) ;
		StudentSample StudentSample3 = new StudentSample("Rajesh", 70, "Maths",3) ;
		StudentSample StudentSample4 = new StudentSample("John", 90, "English",4 ) ;
		StudentSample StudentSample5 = new StudentSample("Maria", 85, "Science",5 ) ;
		StudentSample StudentSample6 = new StudentSample("Ajoy", 78, "IT",6 ) ;
		StudentSample StudentSample7 = new StudentSample("Daniel", 90, "Compter-Science",7 ) ;
		
		List<StudentSample> StudentSamples = Arrays.asList(StudentSample1,StudentSample2,StudentSample3,StudentSample4,StudentSample5,StudentSample6,StudentSample7);
		
		List<StudentSample> StudentSampleWithsubjectMaths = StudentSamples.stream().filter(StudentSample-> StudentSample.getSubject().equals("Maths")).collect(Collectors.toList());
		System.out.println(StudentSampleWithsubjectMaths);
		
		List<StudentSample> StudentSampleWithmarksmorethan70 = StudentSamples.stream().filter(StudentSample-> StudentSample.getMarks()>70).collect(Collectors.toList());
		System.out.println(StudentSampleWithmarksmorethan70);
		
		List<StudentSample> StudentSampleWithmarksmorethan70subjectMaths = StudentSamples.stream().filter(StudentSample-> StudentSample.getMarks()>=70 & StudentSample.getSubject().equals("Maths") ).collect(Collectors.toList());
		System.out.println(StudentSampleWithmarksmorethan70subjectMaths);
		
		

		      
	}	


}
