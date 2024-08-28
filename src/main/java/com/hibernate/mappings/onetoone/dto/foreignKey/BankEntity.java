package com.hibernate.mappings.onetoone.dto.foreignKey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "BANK", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public class BankEntity {
	private static final long serialVersionUID = -6790693372846798580L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer bankId;

	@Column(name = "Bank_Name", unique = true, nullable = false, length = 100)
	private String bankName;
	
	@OneToOne(mappedBy="bank", optional=true)
	private EmployeeEntity employee;


	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}