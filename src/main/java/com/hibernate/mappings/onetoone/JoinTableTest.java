package com.hibernate.mappings.onetoone;

import org.hibernate.Session;

import com.hibernate.config.HibernateUtil;
import com.hibernate.mappings.onetoone.dto.jointable.AccountEntity;
import com.hibernate.mappings.onetoone.dto.jointable.BankEntity;
import com.hibernate.mappings.onetoone.dto.jointable.EmployeeEntity;

public class JoinTableTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		AccountEntity account = new AccountEntity();
		account.setAccountNumber("123-345-78987");
		
		BankEntity bankEntity = new BankEntity();
		bankEntity.setBankName("HDFC");
		
		//Add new Employee object
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmail("abc@mail.com");
		emp.setFirstName("xyz");
		emp.setLastName("abc");
		
		emp.setAccount(account);
		emp.setBank(bankEntity);
		//Save Employee
		session.save(emp);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
