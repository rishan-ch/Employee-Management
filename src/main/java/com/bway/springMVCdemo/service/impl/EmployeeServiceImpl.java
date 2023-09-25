package com.bway.springMVCdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springMVCdemo.model.Employee;
import com.bway.springMVCdemo.repository.EmployeeRepository;
import com.bway.springMVCdemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void addEmployee(Employee emp) {
		
		empRepo.save(emp);
		
	}

	@Override
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		empRepo.save(emp);
		
	}

	@Override
	public Employee getEmpById(Long id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}

}
