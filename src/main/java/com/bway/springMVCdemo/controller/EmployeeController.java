package com.bway.springMVCdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springMVCdemo.model.Employee;
import com.bway.springMVCdemo.service.DepartmentService;
import com.bway.springMVCdemo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService; 
	
	@GetMapping("/employee")
	public String getEmpForm(Model model) {
		model.addAttribute("deptList",deptService.getAllDept());
		return "EmployeeForm";
	}
	
	@PostMapping("/employee")
	public String postEmp(@ModelAttribute Employee emp) {
		empService.addEmployee(emp);
		return "EmployeeForm";
	}
	
	@GetMapping("/empList")
	public String getDeptList(Model model) {
		
		model.addAttribute("empList", empService.getAllEmp());		
		return "EmployeeList";
	}
	
	@GetMapping("/emp/delete/{id}")
	public String delEmp(@PathVariable Long id) {
		
		empService.deleteEmployee(id);
		
		return "redirect:/empList";
	}
	
	@GetMapping("/emp/edit")
	public String editEmp(@RequestParam Long id, Model model) {
		
		model.addAttribute("empModel",empService.getEmpById(id));
		model.addAttribute("deptList",deptService.getAllDept());
		
		return "EmployeeEditForm";
	}
	
	@PostMapping("/emp/update")
	public String update(@ModelAttribute Employee emp) {
		empService.updateEmployee(emp);
		return "redirect:/emplist";
	}

}
