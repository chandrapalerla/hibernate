package com.hibernate.mappings.onetoone.dto.foreignKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ACCOUNT", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class AccountEntity implements Serializable 
{

	private static final long serialVersionUID = -6790693372846798580L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer accountId;

	@Column(name = "ACC_NUMBER", unique = true, nullable = false, length = 100)
	private String accountNumber;
	
	@OneToOne(mappedBy="account", optional=true)
	private EmployeeEntity employee;


	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	
	
}
