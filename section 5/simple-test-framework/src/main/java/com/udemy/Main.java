package com.udemy;

import com.udemy.framework.TestingFramework;
import com.udemy.test.PaymentServiceTest;

public class Main {

	public static void main(String[] args) throws Throwable {
		TestingFramework testingFramework = new TestingFramework();
		testingFramework.runTestSuite(PaymentServiceTest.class);
	}
}
