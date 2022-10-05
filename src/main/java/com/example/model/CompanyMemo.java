package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
@Table(name="company_memo")
public class CompanyMemo {
	@Id
	CompanyMemoKey companyMemoKey;
	String companyMemo;
	
}
