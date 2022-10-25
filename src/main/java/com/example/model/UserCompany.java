package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_company")
public class UserCompany {
	@Id
	private UserCompanyKey mUserCompanyKey;
	private String companyMemo;
}
