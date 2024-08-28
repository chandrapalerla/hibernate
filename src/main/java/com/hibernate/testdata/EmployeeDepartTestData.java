package com.hibernate.testdata;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.beans.EmployeeDeportMent;

public class EmployeeDepartTestData {

	public static List<EmployeeDeportMent> savingEmployeeDepoartment() {
		List<EmployeeDeportMent> list = new ArrayList<EmployeeDeportMent>();
		EmployeeDeportMent emp1 = new EmployeeDeportMent("chandu", "s/w", "IT", "cs");
		list.add(emp1);
		EmployeeDeportMent emp2 = new EmployeeDeportMent("shekar", "h/w", "non IT", "NA");
		list.add(emp2);
		return list;
	}

}
