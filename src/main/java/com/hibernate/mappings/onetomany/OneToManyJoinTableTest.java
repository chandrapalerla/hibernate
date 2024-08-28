package com.hibernate.mappings.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hibernate.config.HibernateUtil;
import com.hibernate.mappings.onetomany.dto.jointable.AccountEntity;
import com.hibernate.mappings.onetomany.dto.jointable.EmployeeEntity;

public class OneToManyJoinTableTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		AccountEntity account1 = new AccountEntity();
		account1.setAccountNumber("123-345-65454");
		
		AccountEntity account2 = new AccountEntity();
		account2.setAccountNumber("123-345-6542222");
		
		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("chandrashekar@gmail.com");
		emp.setFirstName("Palerla");
		emp.setLastName("Chandrashekar");
		
		Set<AccountEntity> accounts = new HashSet<AccountEntity>();
		accounts.add(account1);
		accounts.add(account2);
		
		emp.setAccounts(accounts);
		//Save Employee
		session.save(emp);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
