package com.hibernate.daoimpl;

import java.util.List;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.beans.Student;
import com.hibernate.config.HibernateUtil;
import com.hibernate.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(student);
			// commit transaction
			transaction.commit();
			System.out.println("Student data saved sucessfully-------");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> getStudents() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Student", Student.class).list();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentsBasedOnlastName() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "from Student s where s.lastName = :lastName";
			List<Student> result = session.createQuery(hql).setParameter("lastName", "thigulla").list();
			return result;
		}
	}

	@Override
	public Stream<Student> getStudent() {
		//try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from Student", Student.class).stream();
		//}
	}

}
