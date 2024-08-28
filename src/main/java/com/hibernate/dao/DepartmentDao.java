package com.hibernate.dao;

public interface DepartmentDao {
	
	//getting the total departments
	void totalDepatmentCount();
	
	//getting name based on Id
	void getDeparmentNameById();
	
	//getting department recors using HQL query
	void getDepartments();

}
