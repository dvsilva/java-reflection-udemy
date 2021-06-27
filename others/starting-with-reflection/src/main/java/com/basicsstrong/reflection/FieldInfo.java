package com.basicsstrong.reflection;

import java.lang.reflect.Field;

import com.basicsstrong.reflection.model.Entity;

public class FieldInfo {

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Entity e = new Entity(10, "id");
		Class<?> clss = e.getClass();

		Field[] fields = clss.getFields(); // only public
		for (Field field : fields) {
			System.out.println(field.getName());
		}

		System.out.println("=================");
		
		Field[] declaredFields = clss.getDeclaredFields();  // return all fields
		for (Field field : declaredFields) {
			System.out.println(field.getName());
		}

		System.out.println("=================");
		
		// non-declared : all the public elements in that class and in its super class
		// declared : all the elements present in that class only.

		Field field = clss.getField("type");
		field.set(e, "rollNo.");
		System.out.println(e.getType() + " " + e.getVal());
		
		Field field2 = clss.getDeclaredField("val");
		field2.setAccessible(true); // if not put this get an exception
		field2.set(e, 19);
		System.out.println(e.getType() + " " + e.getVal());
	}

}