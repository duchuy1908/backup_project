package com.aht.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aht.project.entity.BasicSalary;

public interface BasicSalaryRepository extends JpaRepository<BasicSalary, Integer> {

}
