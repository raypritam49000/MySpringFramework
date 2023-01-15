package com.junit.test.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;


public class AppTest {

	@Test
	@DisplayName("First Test Case 1")
	void testSingleSuccessTest1() {
		System.out.println("First Test Case 1");
	}

	@Test
	@DisplayName("First Test Case 2")
	void testSingleSuccessTest2() {
		System.out.println("First Test Case 2");
	}

	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll - executes once before all test methods in this class");
	}

	@BeforeEach
	void init() {
		System.out.println("@BeforeEach - executes before each test method in this class");
	}

	@AfterEach
	void tearDown() {
		System.out.println("@AfterEach - executed after each test method.");
	}

	@AfterAll
	static void done() {
		System.out.println("@AfterAll - executed after all test methods.");
	}
	
	@Test
	void trueAssumption() {
		Assert.assertEquals(5 + 2, 7);
	}
	
	@Test
	void trueAssumption1() {
		Assumptions.assumeTrue(5 > 1);
	}

	@Test
	void assumptionThat() {
	    String someString = "Just a string";
	    Assumptions.assumingThat(someString.equals("Just a string"),() -> Assert.assertEquals(2 + 2, 4));
	}
}
