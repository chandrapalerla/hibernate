package com.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")

@NamedQuery(name = "get_total_dept", query = "select count(1) from Department")
@NamedQueries({ @NamedQuery(name = "get_dept_name_by_id", query = "select name from Department where id=:id"),
		@NamedQuery(name = "get_all_dept", query = "from Department") })
public class Department {
	@Id
	@Column(name = "DPT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "NAME")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
