package com.hibernate.mappings.inheritancemapping.singletable.dto;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("PERMANENT")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PermanentEmployee extends Employee {
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
