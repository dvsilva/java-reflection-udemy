package com.udemy.fields.exercicio;

import java.util.Random;

public abstract class Employee {

	public static final int SALARY_RANGE = 400;
	public static final int MIN_SALARY = 200;

	private final Random random = new Random();

	protected String firstName;
	protected String lastName;
	private int salary;

	protected Employee() {
		this.salary = MIN_SALARY + random.nextInt(SALARY_RANGE);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getSalary() {
		return salary;
	}

}