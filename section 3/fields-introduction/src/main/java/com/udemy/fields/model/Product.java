package com.udemy.fields.model;

//Superclass
public class Product {
	
	protected String name;
	protected int year;
	protected double actualPrice;

	public Product(String name, int year) {
		this.name = name;
		this.year = year;
	}
	
}