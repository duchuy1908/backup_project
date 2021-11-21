package com.aht.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Timesheet2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ; 
	private int monthOfYear;
	@ManyToOne
	private Employee employee ; 
	private String offDay;
}
