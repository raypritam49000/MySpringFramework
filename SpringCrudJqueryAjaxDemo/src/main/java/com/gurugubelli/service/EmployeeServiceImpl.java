package com.gurugubelli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gurugubelli.bean.Employee;
import com.gurugubelli.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDao employeeDao;
	
	public List<Employee> getListOfEmployee() {
		return employeeDao.getListOfEmployee();
	}

	public boolean addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	public boolean updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	public boolean deleteEmployee(String empNo) {
		return employeeDao.deleteEmployee(empNo);
	}

}