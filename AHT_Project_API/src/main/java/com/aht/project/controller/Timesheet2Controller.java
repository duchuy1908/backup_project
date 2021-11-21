package com.aht.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aht.project.service.Timesheets2Service;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/timesheet2")
public class Timesheet2Controller {
	private Timesheets2Service timesheets2Service;
	
	public Timesheet2Controller(Timesheets2Service timesheets2Service) {
		this.timesheets2Service = timesheets2Service;
	}
	
	
	
}
