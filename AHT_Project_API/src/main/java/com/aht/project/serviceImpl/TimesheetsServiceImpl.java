package com.aht.project.serviceImpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aht.project.entity.Employee;
import com.aht.project.entity.Payroll;
import com.aht.project.entity.ServiceResult;
import com.aht.project.entity.Timesheets;
import com.aht.project.repository.EmployeeRepository;
import com.aht.project.repository.PayrollRepository;
import com.aht.project.repository.TimesheetsRepository;
import com.aht.project.service.TimesheetsService;

@Service
public class TimesheetsServiceImpl implements TimesheetsService {

	private TimesheetsRepository timesheetsRepository;
	private EmployeeRepository employeeRepository;
	private PayrollRepository payrollRepository;
	private ServiceResult serviceResult = new ServiceResult();

	public TimesheetsServiceImpl(TimesheetsRepository timesheetsRepository, EmployeeRepository employeeRepository,
			PayrollRepository payrollRepository) {
		this.timesheetsRepository = timesheetsRepository;
		this.employeeRepository = employeeRepository;
		this.payrollRepository = payrollRepository;
	}

	@Override
	public ServiceResult saveAll(List<Timesheets> list) {
		// TODO Auto-generated method stub
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM");
		String time = sm.format(list.get(0).getWorkDate());
		List<Payroll> payrolls = payrollRepository.findByTime(time);
		int size = payrolls.size();
		List<Employee> employees = new ArrayList<>();
		for (Timesheets timesheets : list) {
			if (size <= 0) {
				Payroll payroll = new Payroll();
				payroll.setEmployee(timesheets.getEmployee());
				payroll.setTime(time);
				payrolls.add(payroll);
			}
			if (timesheets.isWorkStatus() == false) {
				employees.add(timesheets.getEmployee());
			}
		}
		for (Employee employee : employees) {
			for (Payroll payroll : payrolls) {
				if (payroll.getEmployee().getId() == employee.getId()) {
					payroll.setNumberOfOffDays(payroll.getNumberOfOffDays() + 1);
				}
			}
		}
		timesheetsRepository.saveAll(list);
		payrollRepository.saveAll(payrolls);
		serviceResult.setMessage("Saved");
		return serviceResult;
	}

	@Override
	public List<Timesheets> getByDateWork(Date date) {
		List<Timesheets> lisTimesheets = new ArrayList<>();
		long millis = System.currentTimeMillis();
		java.sql.Date currentDate = new java.sql.Date(millis);
		int compare = date.toString().compareTo(currentDate.toString());
		if (compare <= 0) {
			lisTimesheets = timesheetsRepository.findByWorkDate(date);
			if (lisTimesheets.size() <= 0) {
				List<Employee> employees = employeeRepository.findAll();
				for (Employee employee : employees) {
					Timesheets timesheets = new Timesheets(employee, false, "");
					lisTimesheets.add(timesheets);
				}
			}
		}
		return lisTimesheets;
	}

	@Override
	public void update(List<Timesheets> list) {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM");
		Date workDate = list.get(0).getWorkDate();
		String time = sm.format(workDate);

		for (Timesheets timesheet : list) {
			Payroll payroll = payrollRepository.findByTimeAndEmployee(time, timesheet.getEmployee());
			if (timesheet.isWorkStatus() != timesheetsRepository.findById(timesheet.getId()).get().isWorkStatus()) {
				if (timesheet.isWorkStatus() == true) {
					payroll.setNumberOfOffDays(payroll.getNumberOfOffDays() - 1);
				} else {
					payroll.setNumberOfOffDays(payroll.getNumberOfOffDays() + 1);
				}
				payrollRepository.save(payroll);
			}
		}

		timesheetsRepository.saveAll(list);
	}

}
