package com.gurugubelli.util;

public class GurugubelliUtil {
	public static final String SELECT_EMP_QUERY = "select * from employee";
	public static final String INSERT_EMP_QUERY = "insert into employee(name,email,salary,city) values(?, ?, ?,?)";
	public static final String UPDATE_EMP_QUERY = "update employee set name = ?, email = ? ,salary = ?, city = ? where id = ?";
	public static final String DELETE_EMP_QUERY = "delete from employee WHERE id = ?";
	public static final String SELECT_EMP_MAX_EMP_NO = "SELECT MAX(EMP_NO) FROM EMPLOYEE;";

	@SuppressWarnings("deprecation")
	public static int getEmpId(String empId) {
		if (empId != null) {
			String temp = empId.substring(5);
			return new Integer(temp);
		}
		return 0;
	}
}