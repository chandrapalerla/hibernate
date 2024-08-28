package com.hibernate.mappings.inheritancemapping;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.config.HibernateUtil;
import com.hibernate.mappings.inheritancemapping.singletable.dto.ContractEmployee;
import com.hibernate.mappings.inheritancemapping.singletable.dto.PermanentEmployee;

public class SingleTableTest {

	public static void main(String[] args) {
		PermanentEmployee permanentEmployee = new PermanentEmployee();
		
		permanentEmployee.setEmployeeId("11201227");
		permanentEmployee.setFirstName("chandrashekar");
		permanentEmployee.setLastName("palerla");
		permanentEmployee.setEmail("chandrashekarpalerla@techwave.net");
		permanentEmployee.setCostCenter("TECHWAVE-VISA");
		permanentEmployee.setTotalLeaves(20.5F);
		permanentEmployee.setStartingDate(LocalDate.parse("2019-09-19"));
			
		ContractEmployee contractEmployee = new ContractEmployee();
		
		contractEmployee.setEmployeeId("VENDOR-11201229");
		contractEmployee.setFirstName("Ramesh");
		contractEmployee.setLastName("telagareddy");
		contractEmployee.setEmail("rameshtelagareddy@techwave.net");
		contractEmployee.setAgencyName("Magna");
		contractEmployee.setContractStartDate(LocalDate.parse("2020-07-12"));
		contractEmployee.setContractEndDate(LocalDate.parse("2021-08-22"));
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(permanentEmployee);
		session.save(contractEmployee);
		
		trans.commit();
		session.close();
	}

}
