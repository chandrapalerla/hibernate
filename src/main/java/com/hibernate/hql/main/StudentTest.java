package com.hibernate.hql.main;

import java.util.List;
import java.util.stream.Collectors;

import com.hibernate.beans.Student;
import com.hibernate.dao.StudentDao;
import com.hibernate.daoimpl.StudentDaoImpl;
import com.hibernate.testdata.StudentTestData;

public class StudentTest {

	public static void main(String[] args) {

		StudentDao studentDao = new StudentDaoImpl();
		List<Student> studentData = StudentTestData.getStudentData();
		for (Student student : studentData) {
			studentDao.saveStudent(student);
		}

		List<Student> students = studentDao.getStudents();
		
		List<Student> collect2 = students.stream().filter(s -> s.getLastName().equals("palerla"))
				.collect(Collectors.toList());
		collect2.forEach(s -> System.out.println(s));

		studentDao.getStudent().map(s -> s.getLastName().toUpperCase()).forEach(s -> System.out.println(s));

		List<Student> studentsList = studentDao.getStudentsBasedOnlastName();
		studentsList.forEach(s -> System.out.println(s));

	}

}
