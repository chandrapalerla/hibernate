package com.hibernate.nativequery.main;

import com.hibernate.dao.DepartmentDao;
import com.hibernate.daoimpl.DepartmentDaoImpl;

public class DepartmentTest {

	public static void main(String[] args) {

		DepartmentDao dao = new DepartmentDaoImpl();
		dao.totalDepatmentCount();

		dao.getDeparmentNameById();
		dao.getDepartments();
	}

}
