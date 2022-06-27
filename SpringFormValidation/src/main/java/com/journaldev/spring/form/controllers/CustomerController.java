package com.journaldev.spring.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.journaldev.spring.form.model.Customer;

@Controller
public class CustomerController {
	
	@GetMapping("/")
	public String home() {
		return "redirect:showCustomeForm";
	}

	@GetMapping("/showCustomerForm")
	public String showCustomerForm() {
		return "custSave";
	}
	
	@PostMapping("/addCustomer")
    public String handleSaveCoustomer(@ModelAttribute Customer customer) {
		System.out.println(customer);
    	return "Cust";
    }
}
