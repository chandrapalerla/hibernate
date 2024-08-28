package com.hibernate.mappings.inheritancemapping.tableperclass.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "tablePerClassPermanentEmployee")
@Table(name = "TABLE_PER_CLASS_PERMANENT_EMPLOYEE")
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
