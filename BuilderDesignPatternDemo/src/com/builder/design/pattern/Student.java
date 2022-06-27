package com.builder.design.pattern;

public class Student {
	private String name;
	private String city;
	private String salary;

	public Student(StudentBuilder studentBuilder) {
		this.name = studentBuilder.name;
		this.city = studentBuilder.city;
		this.salary = studentBuilder.salary;
	}

	public Student build() {
		return this;
	}

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Student setCity(String city) {
		this.city = city;
		return this;
	}

	public String getSalary() {
		return salary;
	}

	public Student setSalary(String salary) {
		this.salary = salary;
		return this;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", city=" + city + ", salary=" + salary + "]";
	}

	public static class StudentBuilder {
		private String name;
		private String city;
		private String salary;

		public StudentBuilder() {
			super();
			// TODO Auto-generated constructor stub
		}

		public StudentBuilder name(String name) {
			this.name = name;
			return this;
		}

		public StudentBuilder city(String city) {
			this.city = city;
			return this;
		}

		public StudentBuilder salary(String salary) {
			this.salary = salary;
			return this;
		}

		public Student build() {
			Student student = new Student(this);
			return student;
		}

	}

}
