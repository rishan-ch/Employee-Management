package com.bway.springMVCdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springMVCdemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
