package com.hibernate.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.beans.Department;
import com.hibernate.config.HibernateUtil;
import com.hibernate.dao.DepartmentDao;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public void totalDepatmentCount() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Long> totalDept = session.createNamedQuery("get_total_dept", Long.class).getResultList();
			System.out.println("Total Department: " + totalDept.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void getDeparmentNameById() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			List<String> deptName = session.createNamedQuery("get_dept_name_by_id", String.class).setParameter("id", 2)
					.getResultList();
			for (Object object : deptName) {
				System.out.println(object);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void getDepartments() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			List<Department> departments = session.createNamedQuery("get_all_dept", Department.class).getResultList();
			for (Department department : departments) {
				System.out.println("ID : " + department.getId() + " \tNAME : " + department.getName());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
