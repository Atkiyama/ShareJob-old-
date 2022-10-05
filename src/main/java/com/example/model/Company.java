package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Entity
@Table(name="company")
public class Company {
	@Id
	private String CompanyId;
	private String CompanyName;
	private String CompanyAbstract;
	//@Transient
	//private List<Event> events;
	
}
