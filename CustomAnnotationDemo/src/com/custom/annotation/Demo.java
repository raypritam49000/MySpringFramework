package com.custom.annotation;

import java.lang.annotation.Annotation;

@MyAnnotation(name = "Pritam Ray", city = "Ropar", myValue = 535)
public class Demo {
	public static void main(String[] args) {

		Demo demo = new Demo();
		
		Class c = demo.getClass();
		
		System.out.println(c.getName());
		
		Annotation annotation = c.getAnnotation(MyAnnotation.class);
		
		MyAnnotation myAnnotation = (MyAnnotation) annotation;
		
		System.out.println(myAnnotation.name());
		System.out.println(myAnnotation.city());
		System.out.println(myAnnotation.myValue());
		
	}
}
