package com.aht.project.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aht.project.entity.Payroll;
import com.aht.project.service.PayrollService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/payroll")
public class PayrollController {
	private PayrollService payrollService;

	public PayrollController(PayrollService payrollService) {
		this.payrollService = payrollService;
	}

	@GetMapping
	public List<Payroll> getPayroll(@RequestParam("time") String time) {
		return payrollService.getPayRollListByTime(time);
	}

	@GetMapping("/compute_salary")
	public List<Payroll> computeSalary(@RequestParam("time") String time) {
		return payrollService.updateSalary(time);
	}
}
