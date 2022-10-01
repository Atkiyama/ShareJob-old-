package com.example.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="m_user")
public class Company {
	private String CompanyId;
	private String CompanyAbstract;
	@Transient
	private List<Event> events;
	
}
