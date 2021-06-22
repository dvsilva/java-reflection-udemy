package com.udemy;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import com.udemy.annotations.OpenResources;
import com.udemy.infraestructure.DatabaseFactory;

public class Exercise {

	public static void main(String[] args) {
		DatabaseFactory object = new  DatabaseFactory();
		Set<Method> allAnnotatedMethods = getAllAnnotatedMethods(object);
		
		for (Method method : allAnnotatedMethods) {
			System.out.println(String.format("The method '%s' is anotted with OpenResources" , method.getName()));
		}
	}

	public static Set<Method> getAllAnnotatedMethods(Object input) {
		Set<Method> annotatedMethods = new HashSet<>();
		
		for (Method method : input.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(OpenResources.class)) {
            	annotatedMethods.add(method);
            }
		}
		
		return annotatedMethods;
	}
}