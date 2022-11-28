package com.example.model;

import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.Data;

public class Event {
	private String name;
	private String eventAbstract;
	 @Transient
	private List<Data> dates;
}
