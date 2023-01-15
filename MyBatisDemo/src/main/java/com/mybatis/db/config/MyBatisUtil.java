package com.mybatis.db.config;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.mybatis.dao.PersonMapper;

public class MyBatisUtil {
 	private static SqlSessionFactory sqlSessionFactory;
 	
	static {
		try {
			DataSource dataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/test",
					"root", "1998");

			Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);

			Configuration configuration = new Configuration(environment);
			configuration.addMapper(PersonMapper.class);

			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = builder.build(configuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
} 