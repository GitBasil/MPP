package com.mpp.practice.prob1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

	public static void main(String[] args) {
		Student s1 = new Student("Samuel", 3.0, Major.COMPUTER_SCIENCE);
		Student s2 = new Student("Pavan", 3.0, Major.COMPUTER_SCIENCE);
		Student s3 = new Student("Jack", 2.3, Major.SOCIOLOGY);
		Student s4 = new Student("Bob", 2.3, Major.COMPUTER_SCIENCE);
		Student s5 = new Student("Lucy", 2.3, Major.EDUCATION_SCIENCE);
		Student s6 = new Student("Zar", 3.3, Major.BASIC_PSYCHOLOGY);
		Student s7 = new Student("Gus", 2.3, Major.EDUCATION_SCIENCE);
		
		List<Student> students = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
		
		// Question 1:
		// Find out all students whose GPA is above 2.8 and major is 'CS' by using stream API.
		System.out.println("Test results = " + filterStudents(students));
	}

	public static List<Student> filterStudents(List<Student> sources) {
		// implement by yourself
		return sources.stream()
				.filter(a -> a.getGpa() > 2.8 && Major.COMPUTER_SCIENCE.equals(a.getMajor()))
				.collect(Collectors.toList());
	}
}
