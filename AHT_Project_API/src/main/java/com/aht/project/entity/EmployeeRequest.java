package com.aht.project.entity;

import lombok.Data;

@Data
public class EmployeeRequest {
		private Integer id ; 
		private String name; 
		private Integer page;
		private Integer limit;
}
