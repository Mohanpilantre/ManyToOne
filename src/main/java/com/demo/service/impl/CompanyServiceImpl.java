package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Company;
import com.demo.repository.CompanyRepository;
import com.demo.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company saveCompany(Company company) {
		Company company1 = companyRepository.save(company);
		return company1;
	}

}
