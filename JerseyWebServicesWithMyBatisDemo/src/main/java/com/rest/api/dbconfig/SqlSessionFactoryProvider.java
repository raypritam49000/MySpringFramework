package com.rest.api.dbconfig;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.mybatis.dao.PersonMapper;

public class SqlSessionFactoryProvider {

	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		try {

			if (sqlSessionFactory == null) {
				
				DataSource dataSource = new PooledDataSource(DBINFO.DRIVER, DBINFO.URL,DBINFO.USERNAME, DBINFO.PASSWORD);

				Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);

				Configuration configuration = new Configuration(environment);
				configuration.addMapper(PersonMapper.class);

				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				sqlSessionFactory = builder.build(configuration);

				return sqlSessionFactory;
			} else {
				return sqlSessionFactory;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}

}
