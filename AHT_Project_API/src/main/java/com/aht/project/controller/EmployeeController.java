package com.aht.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aht.project.entity.Employee;
import com.aht.project.entity.EmployeeRequest;
import com.aht.project.entity.ServiceResult;
import com.aht.project.service.EmployeeService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

//	@GetMapping
//	public ResponseEntity<Object> getAll() {
//		ServiceResult serviceResult = employeeService.findAll();
//		List<Employee> employees = (List<Employee>) serviceResult.getData();
//		if (employees.size() > 0) {
//			System.out.print(employees.size());
//			return new ResponseEntity<>(serviceResult, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}

	@GetMapping
	public ResponseEntity<Object> getTimesheetByDate() {
		return new ResponseEntity<>(employeeService.findAll1(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") int id) {
		ServiceResult serviceResult = employeeService.findById(id);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

		ServiceResult serviceResult = employeeService.save(employee);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) {
		ServiceResult serviceResult = employeeService.delete(id);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		ServiceResult serviceResult = employeeService.update(employee);
		if (serviceResult.isValid()) {
			return new ResponseEntity<>(serviceResult, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping("/search")
	public ResponseEntity<Object> search(@RequestBody EmployeeRequest employeeRequest) {
			return new ResponseEntity<>(employeeService.search(employeeRequest), HttpStatus.OK);

	}
	
	@PostMapping("/search2")
	public ResponseEntity<Object> search2(@RequestBody EmployeeRequest employeeRequest) {
		System.out.println("page1:"+employeeRequest.getPage());
		System.out.println("limit:"+employeeRequest.getLimit());
			return new ResponseEntity<>(employeeService.search2(employeeRequest), HttpStatus.OK);
	}
	
	@GetMapping("/search3")
	public ResponseEntity<Object> search2(@RequestParam("page") int page,@RequestParam("limit") int limit) {
		System.out.println("page1:"+page);
		System.out.println("limit:"+limit);
			return new ResponseEntity<>(page, HttpStatus.OK);

	}

}
