package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="company")
public class Company {
	@Id
	private String companyId;
	private String companyName;
	private String companyAbstract;
	//@Transient
	//private List<Event> events;
	
}
