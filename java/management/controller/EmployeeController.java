package com.employee.management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.entities.Employee;
import com.employee.management.exceptions.EmployeeNotFoundException;
import com.employee.management.repositories.EmployeeRespository;
@CrossOrigin(origins = "http://localhost:4200")//used to say we will get request from this link(angular)
@RestController
public class EmployeeController
{
	@Autowired
	private EmployeeRespository employeeRespository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeRespository.findAll();
		
	}
	@PostMapping("/employees")//http://localhost:8080/employees
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRespository.save(employee);
	}
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId){
		Employee employee=employeeRespository.findById(empId).orElseThrow(()->new EmployeeNotFoundException("Employee with Employee Id "+empId+"doesnot Exist"));
		return ResponseEntity.ok(employee);
	}
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable int empId){
		Employee employee=employeeRespository.findById(empId).orElseThrow(()->new EmployeeNotFoundException("Employee with Employee Id"+empId+"does not exist"));
		employeeRespository.delete(employee);
		Map<String,Boolean> response=new HashMap<String,Boolean>();
		response.put("Deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empId,@RequestBody Employee employeeDetails){
		Employee employee=employeeRespository.findById(empId).orElseThrow(()->
		new EmployeeNotFoundException("Employee with Employee Id "+empId+"doesnot Exist"));
		employee.setEmpName(employeeDetails.getEmpName());
		employee.setDesignation(employeeDetails.getDesignation());
		employee.setEmpSalary(employeeDetails.getEmpSalary());
		employeeRespository.save(employee);
		return ResponseEntity.ok(employee);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//use of node.js to create and run angular projects
	//npm- node package manager
	//-g = to access globally
	//ng version is used to fing angular version
	//--no-standalone = used to create/generate app.module.ts
	//code . =used to open current directory in vs code
	//npm install bootstarp=used install bootstarp to use css in angular using bootstrap
	//to use bootstrap= go to chrome search bootstrap cdn = <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"> paste it in vs code index.html in between head section
	//bootstrap is a simple css library
	//HttpClientModule=used to invoke the restApi(postman) in server(using angular)in app.module.ts=imports
	//ng g class Employee=to create a class in angular
	//ng g s employee=service class in angular`
}
