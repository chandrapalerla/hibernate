package com.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "EMPLOYEE_DEPT")
//@NamedQueries({
//	@NamedQuery(name="gettingEmployee",query="SELECT emp_name FROM EmployeeDeportMent where emp_id=:empId")
//	//@NamedQuery(name="gettingDataScallar", query="SELECT emp_name FROM EmployeeDeportMent")
//})
public class EmployeeDeportMent {

	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue(generator = "employee")
	private int id;
	@Column(name = "EMP_NAME")
	private String name;
	@Column(name = "EMP_DESIG")
	private String designation;
	@Column(name = "EMP_DEPAT")
	private String department;
	@Column(name = "EMP_SUBJECT")
	private String subject;

	public EmployeeDeportMent(String name, String designation, String department, String subject) {
		this.name = name;
		this.designation = designation;
		this.department = department;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
