package com.hibernate.dao;

import com.hibernate.beans.EmployeeDeportMent;

public interface EmployeeDepart {
	
	void saveEmployeeData(EmployeeDeportMent employeeDeportMent);
	//native query
	void gettingAllEmployeeData();
	//native query with custom column selection with scalar query
	void gettingDataScalarQuery();

}
