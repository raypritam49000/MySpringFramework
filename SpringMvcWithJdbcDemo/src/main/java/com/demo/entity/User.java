package com.demo.entity;

public class User {
	private int id;
	private String name;
	private String pass;
	private String email;
	private String mobile;

	public User() {
		super();
	}

	public User(int id, String name, String pass, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.mobile = mobile;
	}

	public User(String name, String pass, String email, String mobile) {
		super();
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
