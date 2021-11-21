package com.aht.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class BasicSalary {
	@Id
	private int level ;
	private int salary ; 
}
