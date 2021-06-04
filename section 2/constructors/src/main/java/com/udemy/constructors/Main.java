/*
 *  MIT License
 *
 *  Copyright (c) 2020 Michael Pogrebinsky - Java Reflection - Master Class
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

/**
 * Constructors
 * https://www.udemy.com/course/java-reflection-master-class
 */
package com.udemy.constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
		printConstructorsData(Person.class);

		Address address = createInstanceWithArguments(Address.class, "First Street", 10);
		System.out.println(address);

		Person person = createInstanceWithArguments(Person.class, address, "John", 20);
		System.out.println(person);
	}

	@SuppressWarnings("unchecked")
	public static <T> T createInstanceWithArguments(Class<T> clazz, Object... args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
		for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
			if (constructor.getParameterTypes().length == args.length) {
				return (T) constructor.newInstance(args);
			}
		}

		System.out.println("An appropriate constructor was not found");
		return null;
	}

	public static void printConstructorsData(Class<?> clazz) {
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();

		System.out.println(String.format("class %s has %d declared constructors", clazz.getSimpleName(), constructors.length));

//    	for (int i = 0 ; i < constructors.length ; i++) {
//     		Class<?> [] parameterTypes = constructors[i].getParameterTypes();
		for (Constructor<?> constructor : constructors) {
			Class<?>[] parameterTypes = constructor.getParameterTypes();

			List<String> parameterTypeNames = Arrays.stream(parameterTypes)
					.map(type -> type.getSimpleName())
					.collect(Collectors.toList());

			System.out.println(parameterTypeNames);
		}
	}

}
