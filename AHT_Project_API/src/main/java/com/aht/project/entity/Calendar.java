package com.aht.project.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class Calendar {
	@Id
	private int id;
	private int month; 
	@ManyToOne
	private Employee employee;
}
