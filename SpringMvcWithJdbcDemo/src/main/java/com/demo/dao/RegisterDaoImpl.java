package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.entity.User;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveUser(User user) {
		int res = jdbcTemplate.update("INSERT INTO user (name,pass,email,mobile) VALUES (?, ?,?,?)", user.getName(),
				user.getPass(), user.getEmail(), user.getMobile());
		
		return res;
	}

}
