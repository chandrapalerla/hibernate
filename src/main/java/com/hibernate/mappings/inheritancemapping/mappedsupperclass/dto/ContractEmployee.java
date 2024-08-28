package com.hibernate.mappings.inheritancemapping.mappedsupperclass.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "mappedSuperClassContractEmployee")
@Table(name = "MAPPED_CONTRACT_EMPLOYEE")
//@PrimaryKeyJoinColumn(name = "ID")
//@DiscriminatorValue("CONTRACT")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ContractEmployee extends Employee {
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private String agencyName;
	public LocalDate getContractStartDate() {
		return contractStartDate;
	}
	public void setContractStartDate(LocalDate contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	public LocalDate getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(LocalDate contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
    
    
}
