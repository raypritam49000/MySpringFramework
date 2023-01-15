package com.gurugubelli.service;

import java.util.List;

import com.gurugubelli.bean.Employee;

public interface EmployeeService {
	
	public List<Employee> getListOfEmployee();

	public boolean addEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public boolean deleteEmployee(String empNo);
}