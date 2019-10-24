package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAllByOrderBySurnameAsc();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("Did not find the user: " + id);
		}
		return employee;
	}

	@Override	
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

}
