package com.aht.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aht.project.entity.Employee;
import com.aht.project.entity.ServiceResult;
import com.aht.project.entity.Timesheet2;

@Service
public interface Timesheets2Service {
	ServiceResult saveAll(List<Timesheet2> list);
	List<Timesheet2> getByMonthOfYear(String month);
	void update(List<Timesheet2> list);
	List<Timesheet2> getByMonthAndEmployee(String month, Employee employee);
}
