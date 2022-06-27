package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.User;
import com.demo.services.RegisterServices;

@Controller
public class RegisterController {

	@Autowired
	private RegisterServices registerServices;

	@RequestMapping(value = "/register/{id}/{name}/{mobile}/{email}", method = RequestMethod.GET)
	// public ModelAndView userdefine(HttpServletRequest request,
	// HttpServletResponse response, HttpSession session)

//	public String userdefine(@RequestParam("name") String name, @RequestParam("pass") String pass,
//			@RequestParam("email") String email, @RequestParam("mobile") String mobile)

//	public String userdefine(@ModelAttribute User user)
	
	public String userdefine(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("email") String email)

	{
		System.out.println(id+" "+name);

		//System.out.println(user.getName() + " " + user.getPass() + " " + user.getEmail() + " " + user.getMobile());
//
//		String name = request.getParameter("name");
//		String pass = request.getParameter("pass");
//		String email = request.getParameter("email");
//		String mobile = request.getParameter("mobile");
////
//		 User user = new User(name, pass, email, mobile);
//
//		int res = this.registerServices.saveUser(user);
//
//		ModelAndView m = new ModelAndView("hellopage" + name + " " + pass + " " + email + " " + mobile);
//		if (res > 0) {
//			m.addObject("msg", "Data saved Successfully");
//		} else {
//			m.addObject("msg", "Data Not Saved");
//		}

		return "Hello";
	}

}
