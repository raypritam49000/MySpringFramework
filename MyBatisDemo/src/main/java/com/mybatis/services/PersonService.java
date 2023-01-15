package com.mybatis.services;

import java.util.List;

import com.mybatis.model.Person;

public interface PersonService {
	public abstract Boolean save(Person person);
	public abstract List<Person> getAllPersons();
	public abstract Person getPerson(Integer personId);
	public abstract Boolean deletePersonById(Integer personId);
	public abstract Boolean updatePerson(Person person);
}
