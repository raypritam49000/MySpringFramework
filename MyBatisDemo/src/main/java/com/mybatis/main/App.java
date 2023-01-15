package com.mybatis.main;

import java.util.List;

import com.mybatis.model.Person;
import com.mybatis.services.PersonService;
import com.mybatis.services.impl.PersonServiceImpl;

public class App {

	public static void main(String[] args) {

		Person person = new Person("Amit Kumar", "Ropar", "56000");
		PersonService personService = new PersonServiceImpl();
		//System.out.println(personService.save(person));
		
		List<Person> persons = personService.getAllPersons();
		//System.out.println(persons);
		//persons.forEach(p->System.out.println(p));
		
		System.out.println(personService.getPerson(9));
		Person upatePerson = new Person(9,"Suraj Mehta", "Prem Nagar", "86000");
		System.out.println(personService.updatePerson(upatePerson));
		System.out.println(personService.getPerson(9));
		
		
		//System.out.println(personService.deletePersonById(3));

	}
}
