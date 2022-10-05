package com.example.model;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.annotation.Transient;

import lombok.Data;

@Data
@Entity
//@Table(name="m_user")
public class Event {
	private String name;
	private String eventAbstract;
	 @Transient
	private List<Data> dates;
}
