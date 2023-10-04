package com.bway.springMVCdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springMVCdemo.model.Department;
import com.bway.springMVCdemo.service.DepartmentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;

	@GetMapping("/department")
	public String getDeptForm(HttpSession session) {
		if(session.getAttribute("validUser")==null) {
			return "Login";
		}
		return "DepartmentForm";
	}
	
	@PostMapping("/department")
	public String postDept(@ModelAttribute Department dept) {
		deptService.addDept(dept);
		return "DepartmentForm";
	}
	
	@GetMapping("/deptList")
	public String getDeptList(Model model) {
		
		model.addAttribute("deptList", deptService.getAllDept());		
		return "deptList";
	}

	@GetMapping("/dept/delete/{id}")
	public String deleteDept(@PathVariable int id) {
		
		deptService.deleteDept(id);
		
		return "redirect:/deptList";
	}
	
	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id, Model model) {
		
		model.addAttribute("deptModel",deptService.getDeptById(id));
		
		return "DepartmentEditForm";
	}
	
	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept) {
		deptService.updateDept(dept);
		return "redirect:/deptList";
		
	}
	
}
