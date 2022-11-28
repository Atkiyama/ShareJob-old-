package com.example.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class UserCompanyKey implements Serializable{
	private String userId;
	private String companyId;

}
