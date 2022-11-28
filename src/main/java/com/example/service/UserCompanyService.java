package com.example.service;

import java.util.List;

import com.example.model.UserCompany;

public interface UserCompanyService {
	 //企業とメモ取得
	

	public List<UserCompany> getUserCompany(String companyId);
	

}
