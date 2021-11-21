package com.aht.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity

public class Payroll {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String time;
	@ManyToOne
	private Employee employee;
	private int numberOfOffDays;
	private int allowance;
	private int totalSalary;

	public Payroll() {

	}

	public Payroll(String time, Employee employee, int numberOfOffDays, int allowance, int totalSalary) {
		super();
		this.time = time;
		this.employee = employee;
		this.numberOfOffDays = numberOfOffDays;
		this.allowance = allowance;
		this.totalSalary = totalSalary;
	}

	public int getNumberOfOffDays() {
		return numberOfOffDays;
	}

	public void setNumberOfOffDays(int numberOfOffDays) {
		this.numberOfOffDays = numberOfOffDays;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

	public int getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}

}
