package com.udemy.fields.exercicio;

import java.lang.reflect.Field;

public class Exercicio {

	public static void main(String[] args) throws SecurityException, ClassNotFoundException {
		Field[] declaredFields = Employee.class.getDeclaredFields();
		printFields(declaredFields);
		
		System.out.println("===========================");
		
		declaredFields = Employee.class.getFields();
		printFields(declaredFields);
		

		System.out.println("===========================");
		
		declaredFields = Class.forName("com.udemy.fields.exercicio.Builder$EmployeeImpl").getDeclaredFields();
		printFields(declaredFields);
	}

	private static void printFields(Field[] declaredFields) {
		for (Field field : declaredFields) {
			System.out.println(String.format("Field name : %s type : %s", field.getName(), field.getType().getName()));
			System.out.println(String.format("Is synthetic field : %s", field.isSynthetic()));
		}
	}
}
