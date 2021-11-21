package com.aht.project.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aht.project.entity.Employee;
import com.aht.project.entity.Timesheet2;

public interface Timesheets2Repository extends JpaRepository<Timesheet2, Integer>{
	List<Timesheet2> findByMonthOfYear(String month);
	
	@Query("SELECT t FROM Timesheet2 t WHERE (:month is null or t.monthOfYear = :month) and (:employee is null or t.employee = :employee)")
	Timesheet2 findByMonthAndEmployee(@Param("month") String month, @Param("employee") Employee employee);
}
