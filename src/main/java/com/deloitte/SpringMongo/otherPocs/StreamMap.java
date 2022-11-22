package com.deloitte.SpringMongo.otherPocs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);
		list.stream().map(number -> number * 3).forEach(System.out::println);
		
		
		List<String> collection = Arrays.asList("Ram", "Shyaam", "Mohan","Ravi", "John", "Miraanda", "Shaun");
		List<String> Group = collection.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(Group);
		
	}

}
