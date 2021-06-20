package com.udemy.fields.exercicio;

/**
 * Employee Builder class
 */
public class Builder {
	
	protected String builderFirstName;
	protected String builderLastName;

	public Builder setFirstName(String firstName) {
		this.builderFirstName = firstName;
		return this;
	}

	public Builder setLastName(String lastName) {
		this.builderLastName = lastName;
		return this;
	}

	public Employee build() {
		return new EmployeeImpl();
	}

	/**
	 * Concrete Employee implementation
	 */
	private class EmployeeImpl extends Employee {
		EmployeeImpl() {
			this.firstName = builderFirstName;
			this.lastName = builderLastName;
		}
	}
}