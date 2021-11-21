package com.aht.project.serviceImpl;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aht.project.entity.DataPage;
import com.aht.project.entity.Employee;
import com.aht.project.entity.EmployeeRequest;
import com.aht.project.entity.ServiceResult;
import com.aht.project.repository.EmployeeRepository;
import com.aht.project.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ServiceResult serviceResult; 

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, ServiceResult serviceResult) {
		this.employeeRepository = employeeRepository;
		this.serviceResult = serviceResult;
	}

	public ServiceResult findAll() {
		serviceResult.setValid(true);
		serviceResult.setMessage("");
		serviceResult.setData(employeeRepository.findAll());
		return serviceResult;
	}

	public DataPage<Employee> findAll1() {
		DataPage<Employee> dataPage = new DataPage<>();
		Page<Employee> page = employeeRepository.findAll(PageRequest.of(0,5));
		int pageIndex = 0;
		dataPage.setData(page.getContent());
		dataPage.setPageIndex(pageIndex);
		dataPage.setPageCount(page.getTotalPages());
		dataPage.setDataCount(page.getTotalElements());
		return dataPage;
	}
	
	public ServiceResult findById(int id) {
		serviceResult.setValid(true);
		serviceResult.setMessage("");
		serviceResult.setData(employeeRepository.findById(id).get());
		return serviceResult;
	}

	public ServiceResult save(Employee employee) {
			employeeRepository.save(employee);
			serviceResult.setValid(true);
			serviceResult.setMessage("Created");
			return serviceResult;
	}
	
	public ServiceResult delete(int id) {
			employeeRepository.deleteById(id);
			serviceResult.setValid(true);
			serviceResult.setMessage("Deleted");
			return serviceResult;
	}
	
	public ServiceResult update(Employee employee) {
			employeeRepository.save(employee);
			serviceResult.setValid(true);
			serviceResult.setMessage("Updated");
			return serviceResult;
	}
	
	public DataPage<Employee> search(EmployeeRequest employeeRequest) {
		DataPage<Employee> dataPage = new DataPage<>();
		Page<Employee> page = employeeRepository.findAll(PageRequest.of(employeeRequest.getPage(), employeeRequest.getLimit()));
		int pageIndex = employeeRequest.getPage()*employeeRequest.getLimit();
		dataPage.setData(page.getContent());
		dataPage.setPageIndex(pageIndex);
		dataPage.setPageCount(page.getTotalPages());
		dataPage.setDataCount(page.getTotalElements());
		return dataPage;
	}
	
	public DataPage<Employee> search2(EmployeeRequest employeeRequest) {

		DataPage<Employee> dataPage = new DataPage<>();
		Page<Employee> page = employeeRepository.search(employeeRequest.getId(), employeeRequest.getName(), PageRequest.of(employeeRequest.getPage(), employeeRequest.getLimit()));
		int pageIndex = employeeRequest.getPage()*employeeRequest.getLimit();
		dataPage.setData(page.getContent());
		dataPage.setPageIndex(pageIndex);
		dataPage.setPageCount(page.getTotalPages());
		dataPage.setDataCount(page.getTotalElements());
		return dataPage;
	}
	
}
