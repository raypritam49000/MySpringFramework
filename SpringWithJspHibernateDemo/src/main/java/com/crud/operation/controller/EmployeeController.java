package com.crud.operation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.operation.dao.EmployeeDao;
import com.crud.operation.entity.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		List<Employee> employees = employeeDao.getAllEmployees();
		model.addAttribute("employees", employees);
		return "index";
	}
	
	@RequestMapping(path = "/showAddEmployeeForm", method = RequestMethod.GET)
	public String showAddEmployeeForm() {
		return "addEmployee";
	}
	
	@RequestMapping(path = "/showUpdateEmployeeForm/{id}", method = RequestMethod.GET)
	public String showUpdateEmployeeForm(@PathVariable("id") int id,Model model) {
		Employee employee = this.employeeDao.getEmployee(id);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}

	@RequestMapping(path = "/addEmployee", method = RequestMethod.POST)
	public String handleAddEmployee(@ModelAttribute Employee employee,HttpServletRequest httpServletRequest) {
		System.out.println(employee);
		this.employeeDao.createEmployee(employee);
		return "redirect:/";
	}
	
	@RequestMapping(path = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public String handleDeleteEmployee(@PathVariable("id") int id,HttpServletRequest httpServletRequest) {
		this.employeeDao.deleteEmployee(id);
		return "redirect:/";
	}
	
	@RequestMapping(path = "/updateEmployee", method = RequestMethod.POST)
	public String handleUpdateEmployee(@ModelAttribute Employee employee,HttpServletRequest httpServletRequest) {
		System.out.println(employee);
		this.employeeDao.updateEmployee(employee.getId(), employee);
		return "redirect:/";
	}
}
