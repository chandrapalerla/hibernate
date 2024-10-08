package com.hibernate.mappings.onetoone.dto.foreignKey;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Employee", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "EMAIL") })
public class EmployeeEntity implements Serializable {
	
	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer employeeId;
	
	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String email;
	
	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	private String lastName;
	
	@OneToOne(targetEntity = AccountEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_ID", referencedColumnName = "ID",unique=true, nullable=false, updatable=false)
	private AccountEntity account;
	
	@OneToOne(targetEntity = BankEntity.class,cascade = CascadeType.ALL)
	@JoinColumn(name="BANK_ID", referencedColumnName = "ID",unique=true, nullable=false, updatable=false)
	private BankEntity bank;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public BankEntity getBank() {
		return bank;
	}

	public void setBank(BankEntity bank) {
		this.bank = bank;
	}
	
	
}
