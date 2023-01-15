package com.gurugubelli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gurugubelli.bean.Employee;
import com.gurugubelli.util.GurugubelliUtil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	public DataSource dataSource;

	public List<Employee> getListOfEmployee() {
		List<Employee> employeesList = new ArrayList<Employee>();
		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GurugubelliUtil.SELECT_EMP_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee emp = new Employee();
				emp.setId(resultSet.getInt("name"));
				emp.setName(resultSet.getString("name"));
				emp.setEmail(resultSet.getString("email"));
				emp.setSalary(resultSet.getString("salary"));
				emp.setCity(resultSet.getString("city"));
				employeesList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeesList;
	}

	public boolean addEmployee(Employee employee) {
		if (employee != null) {
			try {
				Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GurugubelliUtil.INSERT_EMP_QUERY);
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setString(2, employee.getEmail());
				preparedStatement.setString(3, employee.getSalary());
				preparedStatement.setString(4, employee.getCity());
				preparedStatement.executeUpdate();
				preparedStatement.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean updateEmployee(Employee employee) {
		if (employee != null) {
			try {
				System.out.println(employee.toString());
				Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GurugubelliUtil.UPDATE_EMP_QUERY);
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setString(2, employee.getEmail());
				preparedStatement.setString(3, employee.getSalary());
				preparedStatement.setString(4, employee.getCity());
				preparedStatement.setInt(5, employee.getId());
				preparedStatement.executeUpdate();
				preparedStatement.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean deleteEmployee(String id) {
		if (id != null) {
			try {
				Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GurugubelliUtil.DELETE_EMP_QUERY);
				preparedStatement.setInt(5, Integer.parseInt(id));
				preparedStatement.executeUpdate();
				preparedStatement.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}