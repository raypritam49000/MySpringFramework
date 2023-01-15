package com.builder.design.pattern;


public class BuilderDesignPattern {
	public static void main(String[] args) {
//        Student st = new Student();
//        st.setCity("Ropar").setName("Pritam Ray").setSalary("45000");
//        System.out.println(st);
//        
        
         Student student = new Student.StudentBuilder().name("Pritam Ray").city("Ropar").salary("45000").build();
         System.out.println(student);
        
        
        
        User user = new User.UserBuilder("Lokesh", "Gupta")
        		.phone("1234567")
        		.address("Fake address 1234")
        		.age(23)
        		.build();
        
        System.out.println(user);
	}
}
