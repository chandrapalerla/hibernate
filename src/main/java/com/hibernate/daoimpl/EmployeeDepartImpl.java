package com.hibernate.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import com.hibernate.beans.EmployeeDeportMent;
import com.hibernate.config.HibernateUtil;
import com.hibernate.dao.EmployeeDepart;

public class EmployeeDepartImpl implements EmployeeDepart {

	@SuppressWarnings("unchecked")
	@Override
	public void gettingAllEmployeeData() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start a transaction
			transaction = session.beginTransaction();
			List<Object[]> departments = session
					.createNativeQuery("SELECT * FROM EMPLOYEE_DEPT where emp_name=:empname")
					.setParameter("empname", "chandu").list();
			for (Object[] objects : departments) {
				Integer id = (Integer) objects[0];
				String name = (String) objects[1];
				System.out.println("Employee[" + id + "," + name + "]");
			}

			// List<EmployeeDeportMent> departments =
			// session.createNamedQuery("gettingEmployee", EmployeeDeportMent.class)
//					.setParameter("empId", "1").getResultList();
//			for (EmployeeDeportMent employeeDeportMent : departments) {
//				System.out.println("name:::" + employeeDeportMent.getName());
//			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public void saveEmployeeData(EmployeeDeportMent employeeDeportMent) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the employeeDeportMent object
			session.save(employeeDeportMent);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public void gettingDataScalarQuery() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Object[]> employees = session.createNativeQuery("SELECT * FROM employee_dept")
					.addScalar("emp_id", IntegerType.INSTANCE).addScalar("emp_depat", StringType.INSTANCE)
					.addScalar("emp_desig", StringType.INSTANCE).addScalar("emp_name", StringType.INSTANCE).list();
			for (Object[] objects : employees) {
				Integer id = (Integer) objects[0];
				String dpt = (String) objects[1];
				String designation = (String) objects[2];
				String name = (String) objects[3];
				System.out.println("Employee[" + id + "," + dpt + "," + designation + "," + name + "]");
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

}
