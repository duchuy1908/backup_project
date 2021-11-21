package com.aht.project.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aht.project.entity.Timesheets;

public interface TimesheetsRepository extends JpaRepository<Timesheets, Integer> {
	List<Timesheets> findByWorkDate(Date date);
	
	@Query("SELECT t FROM Timesheets t WHERE (:id is null or t.id = :id) and (:date is null or t.workDate = :workdate)")
	Timesheets findByIdAnDate(@Param("id") int id, @Param("workdate") Date wordDate);
}
