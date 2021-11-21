package com.aht.project.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aht.project.entity.Employee;
import com.aht.project.entity.ServiceResult;
import com.aht.project.entity.Timesheet2;
import com.aht.project.service.Timesheets2Service;

@Service
public class Timesheets2ServiceImpl implements Timesheets2Service{

	@Override
	public ServiceResult saveAll(List<Timesheet2> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Timesheet2> getByMonthOfYear(String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(List<Timesheet2> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Timesheet2> getByMonthAndEmployee(String month, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
