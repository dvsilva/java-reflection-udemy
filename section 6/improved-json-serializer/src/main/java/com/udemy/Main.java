package com.udemy;

public class Main {

    public static void main(String[] args) throws Throwable {
    	// {"street":"Main Street","apartment":1}
    	Address address = new Address("Main Street", (short) 1, "12345");

    	String objectToJson = JsonWriter.objectToJson(address);
    	System.out.println(objectToJson);
    }
}