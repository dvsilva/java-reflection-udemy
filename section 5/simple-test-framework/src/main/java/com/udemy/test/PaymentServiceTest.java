package com.udemy.test;

import com.udemy.services.PaymentService;

/**
 * Represents a test suite for testing the PaymentService
 */
public class PaymentServiceTest {
	
    private PaymentService service;
    
    public static void beforeClass() {
        // Called in the beginning of the test suite only once
        // Used for all tests need to share computationally expensive setup
    	System.out.println("Executando método 'beforeClass'");
    }
    
    public void setupTest() {
        // Called before every test
        // Used for setting up resource before every test
    	System.out.println("Executando método 'setupTest'");
    }
    
    public void testCreditCardPayment() {
        // Test case 1
    	System.out.println("Executando método 'testCreditCardPayment'");
    }
    
    public void testWireTransfer() {
        // Test case 2
    	System.out.println("Executando método 'testWireTransfer'");
    }
    
    public void testInsufficientFunds() {
        // Test case 3
    	System.out.println("Executando método 'testInsufficientFunds'");
    }

    public void abcTestNothing() {
        // Test case 3
    	System.out.println("Executando método 'abcTestNothing'");
    }
    
    public static void afterClass() {
        // Called once in the end of the entire test suite
        // Used for closing and cleaning up common resources
    	System.out.println("Executando método 'afterClass'");
    }
}