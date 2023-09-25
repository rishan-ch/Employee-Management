package com.bway.springMVCdemo.service;

import java.util.List;

import com.bway.springMVCdemo.model.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee emp);
	void deleteEmployee(Long id);
	void updateEmployee(Employee emp);
	Employee getEmpById(Long id);
	List<Employee> getAllEmp();

}
