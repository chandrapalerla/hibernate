package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.hibernate.beans.Employee;

public class StoreData {
	public static void main(String[] args) {

		Session session = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setId(101);
		e1.setFirstName("chandu");
		e1.setLastName("shekar");

		session.save(e1);
		t.commit();
		System.out.println("successfully saved");
		session.close();

	}
}