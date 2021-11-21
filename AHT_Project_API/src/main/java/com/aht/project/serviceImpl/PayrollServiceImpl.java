package com.aht.project.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aht.project.entity.BasicSalary;
import com.aht.project.entity.Payroll;
import com.aht.project.repository.BasicSalaryRepository;
import com.aht.project.repository.EmployeeRepository;
import com.aht.project.repository.PayrollRepository;
import com.aht.project.service.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService{

	private PayrollRepository payrollRepository; 
	private EmployeeRepository employeeRepository;
	private BasicSalaryRepository basicSalaryRepository;
	
	public PayrollServiceImpl(PayrollRepository payrollRepository,  EmployeeRepository employeeRepository, BasicSalaryRepository basicSalaryRepository){
		this.payrollRepository = payrollRepository;
		this.employeeRepository = employeeRepository;
		this.basicSalaryRepository = basicSalaryRepository;
	}
	
	@Override
	public void save(List<Payroll> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Payroll> getPayRollListByTime(String time) {
		
		return payrollRepository.findByTime(time);
	}

	@Override
	public List<Payroll> updateSalary(String time) {
		int totalSalary = 0 ;
		List<Payroll> payrolls = payrollRepository.findByTime(time);
		if(payrolls.size()>0) {
			for (Payroll payroll : payrolls) {
				int basicSalary = basicSalaryRepository.findById(payroll.getEmployee().getLevel()).get().getSalary();
				totalSalary = (basicSalary / 26) * (26 - payroll.getNumberOfOffDays()) + payroll.getAllowance();
				payroll.setTotalSalary(totalSalary);
				payrollRepository.save(payroll);
			}
		}
		return payrollRepository.findByTime(time);
	}

	
}
