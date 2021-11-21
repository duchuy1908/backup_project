package com.aht.project.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aht.project.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query("SELECT e FROM Employee e WHERE (:id is null or e.id = :id) and (:name is null or e.name like %:name%)")
		Page<Employee> search(@Param("id") Integer id, @Param("name") String name, Pageable pageable);
	 
}
