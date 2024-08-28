package com.hibernate.mappings.inheritancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.config.HibernateUtil;
import com.hibernate.mappings.inheritancemapping.mappedsupperclass.dto.ContractEmployee;
import com.hibernate.mappings.inheritancemapping.mappedsupperclass.dto.PermanentEmployee;

import java.time.LocalDate;

public class MappedSuperClassTest {
    public static void main(String[] args) {
    	PermanentEmployee permanentEmployee = new PermanentEmployee();
		permanentEmployee.setEmployeeId("EMP-001");
		permanentEmployee.setFirstName("John");
		permanentEmployee.setLastName("West");
		permanentEmployee.setEmail("john@john.com");
		permanentEmployee.setCostCenter("AAA-111");
		permanentEmployee.setTotalLeaves(12.50F);
		permanentEmployee.setStartingDate(LocalDate.parse("2018-03-10"));

		ContractEmployee contractEmployee = new ContractEmployee();
		contractEmployee.setEmployeeId("EMP-002");
		contractEmployee.setFirstName("Richard");
		contractEmployee.setLastName("Smith");
		contractEmployee.setEmail("richard@richard.com");
		contractEmployee.setAgencyName("CONTRACT AGENCY");
		contractEmployee.setContractStartDate(LocalDate.parse("2018-07-12"));
		contractEmployee.setContractEndDate(LocalDate.parse("2019-02-22"));

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        session.persist(permanentEmployee);
        session.persist(contractEmployee);
        trans.commit();
        session.close();
    }
}
