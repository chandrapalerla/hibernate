package com.hibernate.nativequery.main;

import com.hibernate.dao.EmployeeDepart;
import com.hibernate.daoimpl.EmployeeDepartImpl;

public class EmployeeDepartTest {

	public static void main(String[] args) {
		EmployeeDepart empDepo = new EmployeeDepartImpl();
		// saving the data
//		List<EmployeeDeportMent> empDepoartment = EmployeeDepartTestData.savingEmployeeDepoartment();
//		for (EmployeeDeportMent employeeDeportMent : empDepoartment) {
//			empDepo.saveEmployeeData(employeeDeportMent);
//		}
		//getting all data
		empDepo.gettingAllEmployeeData();
		
		//getting data with scalar query
		empDepo.gettingDataScalarQuery();

	}

}
