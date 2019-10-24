package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;
	
	@PostConstruct
	public void loadData() {
		
		Employee emp1 = new Employee(1,"Janek","Burczymucha","janek@ja.com");
		Employee emp2 = new Employee(2,"Krzysiu","Jarzyna","jarzyna@ja.com");
		Employee emp3 = new Employee(3,"Roman","Kielich","romki@ja.com");
		
		theEmployees = new ArrayList<Employee>();
		
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		model.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
