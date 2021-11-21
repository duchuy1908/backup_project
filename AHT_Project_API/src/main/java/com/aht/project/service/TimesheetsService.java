package com.aht.project.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aht.project.entity.ServiceResult;
import com.aht.project.entity.Timesheets;

@Service
public interface TimesheetsService {
	ServiceResult saveAll(List<Timesheets> list);
	List<Timesheets> getByDateWork(Date date);
	void update(List<Timesheets> list);
	
}
