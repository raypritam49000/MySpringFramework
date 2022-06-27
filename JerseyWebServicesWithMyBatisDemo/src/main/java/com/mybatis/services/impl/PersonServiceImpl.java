package com.mybatis.services.impl;

import java.util.List;

import javax.inject.Singleton;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.PersonMapper;
import com.mybatis.model.Person;
import com.mybatis.services.PersonService;
import com.rest.api.dbconfig.SqlSessionFactoryProvider;

@Singleton
public class PersonServiceImpl implements PersonService {

	@Override
	public Boolean save(Person person) {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		int result = mapper.save(person);
		session.commit();

		if (result > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Person> getAllPersons() {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		List<Person> persons = mapper.getAllPersons();
		session.commit();
		return persons;
	}

	@Override
	public Person getPerson(Integer personId) {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = mapper.getPerson(personId);
		session.commit();
		return person;
	}

	@Override
	public Boolean deletePersonById(Integer personId) {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		mapper.deletePersonById(personId);
		session.commit();
		return true;
	}

	@Override
	public Boolean updatePerson(Person person) {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		mapper.updatePerson(person);
		session.commit();
		return true;
	}

}
