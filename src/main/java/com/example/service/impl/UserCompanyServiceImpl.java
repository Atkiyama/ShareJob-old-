package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.model.UserCompany;
import com.example.repository.UserCompanyRepository;
import com.example.service.UserCompanyService;
@Service
@Primary
public class UserCompanyServiceImpl implements UserCompanyService{

	@Autowired
    private UserCompanyRepository repository;
	
	@Override
	public List<UserCompany> getUserCompany(String userId) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findAllByUserId(userId);
	}
	

}
