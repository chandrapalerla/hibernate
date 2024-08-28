package com.hibernate.mappings.onetoone;

import org.hibernate.Session;

import com.hibernate.config.HibernateUtil;
import com.hibernate.mappings.onetoone.dto.foreignKey.AccountEntity;
import com.hibernate.mappings.onetoone.dto.foreignKey.BankEntity;
import com.hibernate.mappings.onetoone.dto.foreignKey.EmployeeEntity;

public class OneToOneForeignKeyTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		AccountEntity account = new AccountEntity();
		account.setAccountNumber("123-345-65454");
		
		BankEntity bankEntity = new BankEntity();
		bankEntity.setBankName("HDFC");
		
		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("chandupalerla@mail.com");
		emp.setFirstName("chandu");
		emp.setLastName("palerla");
		
		//Save Account
		session.saveOrUpdate(account);
		//save Bank
		session.saveOrUpdate(bankEntity);
		//Save Employee
		emp.setAccount(account);
		emp.setBank(bankEntity);
		session.saveOrUpdate(emp);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();

	}

}
