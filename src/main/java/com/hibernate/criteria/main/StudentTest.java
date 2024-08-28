package com.hibernate.criteria.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.beans.Student;
import com.hibernate.config.HibernateUtil;

public class StudentTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			
			Criteria createCriteria = session.createCriteria(Student.class);
			List<Student> list = createCriteria.list();
//			for (Student student : list) {
//				System.out.println(student.getFirstName());
//			}
			list.stream().filter(s->s.getLastName().equals("palerla")).map(s->s.getFirstName().toUpperCase()).distinct().forEach(System.out::println);
					
			session.createCriteria(Student.class).add(Restrictions.eq("firstName", "chandu")).list().forEach(System.out::println);

			Criteria cr1 = session.createCriteria(Student.class);
			
			cr1.add(Restrictions.ilike("lastName", "%palerl%"));
			List<Student> results1 = cr1.list();
			System.out.println(results1);
			
			session.createCriteria(Student.class).add(Restrictions.and(Restrictions.eq("lastName", "thigulla"),Restrictions.eq("firstName", "raju"))).list().forEach(System.out::println);;

//			Criterion lastName = Restrictions.eq("lastName", "thigulla");
//			Criterion firstName = Restrictions.eq("firstName", "raju");
//			
//			LogicalExpression orExx = Restrictions.or(firstName, lastName);
//
//			cr2.add(orExx);
//			List<Student> list2 = cr2.list();
//			System.out.println(list2);
			
			List<Student> list2 = session.createCriteria(Student.class).setFirstResult(2).setMaxResults(5).list();
			list2.stream().filter(s->s.getFirstName().length()>5).forEach(System.out::println);
			
			Criteria cr4 = session.createCriteria(Student.class);
//			Criteria setProjection = cr4.setProjection(Projections.rowCount());
//			System.out.println(setProjection.uniqueResult());
			
			Criteria setProjection = cr4.setProjection(Projections.countDistinct("lastName"));
			System.out.println(setProjection.uniqueResult());	
			
			

			tx.commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
