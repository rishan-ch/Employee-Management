package com.bway.springMVCdemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.springMVCdemo.model.Employee;
import com.bway.springMVCdemo.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService empService;

	@GetMapping("/api/emp/list")
	public List<Employee> getEmps() {
		
		return empService.getAllEmp();
	}
	
	@PostMapping("/api/emp/add")
	public String add(@RequestBody Employee emp) {
		empService.addEmployee(emp);
		return "added success";
	}
	
	@DeleteMapping("/api/emp/delete/{id}")
	public String delete(@PathVariable Long id) {
		
		empService.deleteEmployee(id);
		
		return "delete success";
	}
	
	@GetMapping("/api/emp/{id}")
	public Employee getEmp(@PathVariable Long id) {
		return empService.getEmpById(id);
	}
	
	@PutMapping("/api/emp/update")
	public String update(@RequestBody Employee emp) {
		empService.updateEmployee(emp);
		return "update success";
	}
	
	//change json data into object
	@GetMapping("/api/emp/jsontoobj")
	public String jsonToObject() {
		
		RestTemplate temp = new RestTemplate();
		Employee emp = temp.getForObject("http://localhost:8080/api/emp/8", Employee.class);
		
		return "fname = " + emp.getFname();
	}
	
	//change into array
	@GetMapping("/api/emp/jarrayToObjArray")
	public String jsonArrayToObjectArray() {
		RestTemplate temp = new RestTemplate();
		Employee[] emps = temp.getForObject("http://localhost:8080/api/emp/list", Employee[].class);
		
		return "firstname = "+emps[0].getLname();
	}
}
