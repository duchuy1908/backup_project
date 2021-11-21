package com.aht.project.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aht.project.entity.ServiceResult;
import com.aht.project.entity.Timesheets;
import com.aht.project.service.TimesheetsService;

@RestController
@RequestMapping("/api/timesheets")
@CrossOrigin("*")
public class TimesheetsController {
	private TimesheetsService timesheetsService;

	public TimesheetsController(TimesheetsService timesheetsService) {
		this.timesheetsService = timesheetsService;
	}

	@GetMapping
	public List<Timesheets> getTS(@RequestParam("date") Date date) {
		return timesheetsService.getByDateWork(date);
	}

	@PostMapping("/add")
	public ServiceResult add(@RequestBody List<Timesheets> list) {
		return timesheetsService.saveAll(list);
	}

	@PutMapping("/update")
	public void update(@RequestBody List<Timesheets> list) {
		timesheetsService.update(list);
	}
}
