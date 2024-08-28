package com.hibernate.testdata;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.beans.Student;

public class StudentTestData {

	public static List<Student> getStudentData(){

		ArrayList<Student> arrayList = new ArrayList<Student>();
		Student s1 = new Student("chandu", "palerla", "chandupalerla@gmail.com");
		arrayList.add(s1);
		Student s2 = new Student("komali", "palerla", "komlaipalerla@gmail.co");
		arrayList.add(s2);
		Student s3 = new Student("kaoushik", "palerla", "kaoushikpalerla@gmail.com");
		arrayList.add(s3);
		Student s4 = new Student("raju", "thigulla", "rajuthigulla@gmail.com");
		arrayList.add(s4);
		Student s5 = new Student("mahesh", "palerla", "maheshpalerla@gmail.com");
		arrayList.add(s5);
		Student s6 = new Student("varshith", "thigulla", "varshiththigulla@gmail.com");
		arrayList.add(s6);
		Student s7 = new Student("rishi", "palerla", "rishipalerla@gmail.com");
		arrayList.add(s7);
		Student s8 = new Student("kittu", "thigulla", "kittuthigulla@gmail.com");
		arrayList.add(s8);
		Student s9 = new Student("mamatha", "thigulla", "mamathathigulla@gmail.com");
		arrayList.add(s9);
		Student s10 = new Student("rakesh", "konda", "rakeshkonda@gmail.com");
		arrayList.add(s10);
		
		return arrayList;
		
	}
}
