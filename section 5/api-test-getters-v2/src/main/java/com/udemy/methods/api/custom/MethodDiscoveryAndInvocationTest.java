package com.udemy.methods.api.custom;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.udemy.methods.api.Product;

public class MethodDiscoveryAndInvocationTest {

	public static void main(String[] args) {
		List<Field> allFields = getAllFields(Product.class);
		
		allFields.stream()
			.map(Field::getName)
			.forEach(System.out::println);
		
		System.out.println("=======================");
		
		List<Method> allMethods = getAllMethods(Product.class);
		
		allMethods.stream()
			.map(Method::getName)
			.forEach(System.out::println);
		
		System.out.println("=======================");
		
		List<Constructor> allConstructors = getAllConstructors(Product.class);
		
		allConstructors.stream()
			.map(Constructor::getName)
			.forEach(System.out::println);
	}

    private static List<Field> getAllFields(Class<?> clazz) {
        if (clazz == null || clazz.equals(Object.class)) {
            return Collections.emptyList();
        }

        Field[] currentClassFields = clazz.getDeclaredFields();

        List<Field> inheritedFields = getAllFields(clazz.getSuperclass());

        List<Field> allFields = new ArrayList<>();

        allFields.addAll(Arrays.asList(currentClassFields));
        allFields.addAll(inheritedFields);

        return allFields;
    }

    private static List<Method> getAllMethods(Class<?> clazz) {
        if (clazz == null || clazz.equals(Object.class)) {
            return Collections.emptyList();
        }

        Method[] currentClassMethods = clazz.getDeclaredMethods();

        List<Method> inheritedMethods = getAllMethods(clazz.getSuperclass());

        List<Method> allMethods = new ArrayList<>();

        allMethods.addAll(Arrays.asList(currentClassMethods));
        allMethods.addAll(inheritedMethods);

        return allMethods;
    }
    
    private static List<Constructor> getAllConstructors(Class<?> clazz) {
        if (clazz == null || clazz.equals(Object.class)) {
            return Collections.emptyList();
        }

        Constructor[] currentClassConstructors = clazz.getDeclaredConstructors();

        List<Constructor> inheritedConstructors = getAllConstructors(clazz.getSuperclass());

        List<Constructor> allConstructors = new ArrayList<>();

        allConstructors.addAll(Arrays.asList(currentClassConstructors));
        allConstructors.addAll(inheritedConstructors);

        return allConstructors;
    }
}
