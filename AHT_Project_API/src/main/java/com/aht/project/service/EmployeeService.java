package com.aht.project.service;



import org.springframework.stereotype.Service;

import com.aht.project.entity.DataPage;
import com.aht.project.entity.Employee;
import com.aht.project.entity.EmployeeRequest;
import com.aht.project.entity.ServiceResult;

@Service
public interface EmployeeService {
	public ServiceResult findAll();
	public DataPage<Employee> findAll1();
	public ServiceResult findById(int id);
	public ServiceResult save(Employee employee);
	public ServiceResult delete(int id);
	public ServiceResult update(Employee employee);
	public DataPage<Employee> search(EmployeeRequest employeeRequest);
	public DataPage<Employee> search2(EmployeeRequest employeeRequest);

}
