package com.bway.springMVCdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.springMVCdemo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
