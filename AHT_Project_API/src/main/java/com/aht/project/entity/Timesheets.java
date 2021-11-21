package com.aht.project.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Timesheets {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ; 
	@ManyToOne
	private Employee employee ; 
	private Date workDate; 
	private boolean workStatus ; 
	private String note; 	
	
	
	
	public Timesheets(Employee employee,Boolean workStatus, String note) {
		this.employee = employee;
		this.workStatus = workStatus; 
		this.note = note ; 
	}

	public Timesheets(int id, Employee employee, Date workDate, boolean workStatus, String note) {
		super();
		this.id = id;
		this.employee = employee;
		this.workDate = workDate;
		this.workStatus = workStatus;
		this.note = note;
	}



	public Timesheets() {
		super();
	}
}
