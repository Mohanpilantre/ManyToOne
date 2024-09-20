package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Company;
import com.demo.model.Employee;
import com.demo.service.CompanyService;
import com.demo.service.EmployeeService;

@RestController
public class CompanyEmployeeController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveCompany")
	public Company saveCompany(@RequestBody Company company) {
		Company com = companyService.saveCompany(company);
		List<Employee> list = company.getEmployeeList();
		for (Employee emp : list) {
			emp.setCompanyId(company.getId());
			employeeService.saveEmployee(emp);
		}
		return com;
	}

}
