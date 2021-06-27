package com.basicsstrong.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.basicsstrong.reflection.model.Entity;

public class MethodInfo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Entity e = new Entity(10, "id");
		Class<?> clss = e.getClass();

		Method[] methods = clss.getMethods(); // get methods from superclass
		for (Method method : methods) {
			System.out.println(method);
		}

		System.out.println("------------");

		Method[] declaredMethods = clss.getDeclaredMethods();// get methods only by the class
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}

		System.out.println("------------");
		
		Method method = clss.getDeclaredMethod("setVal", int.class);
		method.setAccessible(true);
		method.invoke(e, 15);

		Method method2 = clss.getMethod("getVal", null);
		System.out.println(method2.invoke(e, null));

	}

}
