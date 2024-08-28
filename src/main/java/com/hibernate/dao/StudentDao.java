package com.hibernate.dao;

import java.util.List;
import java.util.stream.Stream;

import com.hibernate.beans.Student;

public interface StudentDao {

	void saveStudent(Student student);

	List<Student> getStudents();
	
	Stream<Student> getStudent();

	// named query
	List<Student> getStudentsBasedOnlastName();
}
