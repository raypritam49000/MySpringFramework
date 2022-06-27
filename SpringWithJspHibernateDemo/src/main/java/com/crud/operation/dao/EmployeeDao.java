package com.crud.operation.dao;

import java.util.List;

import com.crud.operation.entity.Employee;

public interface EmployeeDao {
	public abstract void createEmployee(Employee employee);
	public abstract List<Employee> getAllEmployees();
	public abstract Employee getEmployee(int id);
	public abstract void deleteEmployee(int id);
	public void updateEmployee(int id, Employee updateEmployee);
}
