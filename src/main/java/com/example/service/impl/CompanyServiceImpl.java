package com.example.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.model.Company;
import com.example.repository.CompanyRepository;
import com.example.service.CompanyService;
@Service
@Primary
public class CompanyServiceImpl implements CompanyService{

	@Autowired
    private CompanyRepository repository;
	
	@Override
	public Company getCompany(String companyId) {
		// TODO 自動生成されたメソッド・スタブ
	    Optional<Company> option = repository.findById(companyId);
		return option.orElse(null);
	}
	

}
