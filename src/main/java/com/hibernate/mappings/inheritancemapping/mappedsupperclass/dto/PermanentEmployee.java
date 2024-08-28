package com.hibernate.mappings.inheritancemapping.mappedsupperclass.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "mappedSuperClassPermanentEmployee")
@Table(name = "MAPPED_PERMANENT_EMPLOYEE")
//@PrimaryKeyJoinColumn(name = "ID")
//@DiscriminatorValue("PERMANENT")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PermanentEmployee extends Employee{
	
	private LocalDate startingDate;
	private String costCenter;
	private Float totalLeaves;

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public Float getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(Float totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

}
