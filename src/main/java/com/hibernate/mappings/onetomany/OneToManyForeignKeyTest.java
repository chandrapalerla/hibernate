package com.hibernate.mappings.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hibernate.config.HibernateUtil;
import com.hibernate.mappings.onetomany.dto.foreignkey.AccountEntity;
import com.hibernate.mappings.onetomany.dto.foreignkey.EmployeeEntity;

public class OneToManyForeignKeyTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		AccountEntity account1 = new AccountEntity();
		account1.setAccountNumber("31753022128");
		
		AccountEntity account2 = new AccountEntity();
		account2.setAccountNumber("317589648545");
		
		AccountEntity account3 = new AccountEntity();
		account3.setAccountNumber("31753022157");
		
		//Add new Employee object
		EmployeeEntity firstEmployee = new EmployeeEntity();
		firstEmployee.setEmail("chandupalerla@gmail.com");
		firstEmployee.setFirstName("chandrashekar");
		firstEmployee.setLastName("palerla");
		
		EmployeeEntity secondEmployee = new EmployeeEntity();
		secondEmployee.setEmail("komalipalerla@gmail.com");
		secondEmployee.setFirstName("komali");
		secondEmployee.setLastName("palerla");
		
		Set<AccountEntity> accountsOfFirstEmployee = new HashSet<AccountEntity>();
		accountsOfFirstEmployee.add(account1);
		accountsOfFirstEmployee.add(account2);
		
		Set<AccountEntity> accountsOfSecondEmployee = new HashSet<AccountEntity>();
		accountsOfSecondEmployee.add(account3);
		
		firstEmployee.setAccounts(accountsOfFirstEmployee);
		secondEmployee.setAccounts(accountsOfSecondEmployee);
		//Save Employee
		session.save(firstEmployee);
		session.save(secondEmployee);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();

	}

}
