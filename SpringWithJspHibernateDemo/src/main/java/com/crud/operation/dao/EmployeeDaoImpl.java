package com.crud.operation.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.crud.operation.entity.Employee;

@Component
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void createEmployee(Employee employee) {
		hibernateTemplate.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.hibernateTemplate.loadAll(Employee.class);
	}

	@Override
	public void deleteEmployee(int id) {
		Employee employee = this.hibernateTemplate.load(Employee.class, id);
		if (employee != null) {
			this.hibernateTemplate.delete(employee);
		}
	}

	@Override
	public void updateEmployee(int id, Employee updateEmployee) {
		Employee employee = this.hibernateTemplate.get(Employee.class, id);
		if (employee != null) {
			employee.setCity(updateEmployee.getCity());
			employee.setName(updateEmployee.getName());
			employee.setSalary(updateEmployee.getSalary());
			this.hibernateTemplate.save(employee);
		}

	}

	@Override
	public Employee getEmployee(int id) {
		Employee employee = this.hibernateTemplate.get(Employee.class, id);
		return employee;
	}

}
