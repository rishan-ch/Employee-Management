package com.bway.springMVCdemo.service;

import java.util.List;

import com.bway.springMVCdemo.model.Department;

public interface DepartmentService {
	
	void addDept(Department dept);
	void deleteDept(int id);
	void updateDept(Department dept);
	List<Department> getAllDept();
	Department getDeptById(int id);

}
