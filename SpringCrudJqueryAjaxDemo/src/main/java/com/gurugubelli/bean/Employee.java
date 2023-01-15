package com.gurugubelli.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;
	private String city;
	private String salary;
}