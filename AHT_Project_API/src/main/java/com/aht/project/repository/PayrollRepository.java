package com.aht.project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aht.project.entity.Employee;
import com.aht.project.entity.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
	List<Payroll> findByTime(String time);
	
	@Query("SELECT p FROM Payroll p WHERE (:time is null or p.time = :time) and ( p.employee = :employee)")
	Payroll findByTimeAndEmployee(@Param("time") String time,@Param("employee") Employee employee);
	
}
