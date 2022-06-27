package com.crud.operation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

	@GetMapping("/hello")
	@ResponseBody
	public String helloWor1d() {
		System.out.println("Hello Pritam Ray");
		return "Hello Pritam Ray";
	}
}
