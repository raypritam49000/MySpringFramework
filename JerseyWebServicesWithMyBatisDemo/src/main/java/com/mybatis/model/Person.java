package com.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private Integer id;
	private String name;
	private String city;
	private String salary;

	public Person(String name, String city, String salary) {
		super();
		this.name = name;
		this.city = city;
		this.salary = salary;
	}

}
