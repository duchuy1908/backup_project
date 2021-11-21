package com.aht.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aht.project.entity.Payroll;

@Service
public interface PayrollService {
	List<Payroll> getPayRollListByTime(String time);
	void save(List<Payroll> list);
	List<Payroll> updateSalary(String time);
}
