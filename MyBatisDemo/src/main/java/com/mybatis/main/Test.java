package com.mybatis.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.PersonMapper;
import com.mybatis.model.Person;

public class Test {
	public static void main(String[] args) {
		try {

			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			System.out.println(session);
			
			PersonMapper mapper = session.getMapper(PersonMapper.class);
			List<Person> persons = mapper.getAllPersons();
			session.commit();
			
			System.out.println(persons);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
