package com.basicsstrong.reflection;

import java.lang.reflect.Constructor;

import com.basicsstrong.reflection.model.Entity;

public class ConstructorInfo {

	public static void main(String[] args) throws Exception {

		Class<?> clss = Class.forName("com.basicsstrong.reflection.model.Entity");
//		Constructor<?>[] constructors = clss.getConstructors(); // get only public onstructors
		Constructor<?>[] constructors = clss.getDeclaredConstructors(); // get all constructors

		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}

		Constructor<?> publicConstructor = clss.getConstructor(int.class, String.class);
		Entity e = (Entity) publicConstructor.newInstance(10, "StudenId");
		System.out.println(e.getVal() + " " + e.getType());

		Constructor<?> privateConstructor = clss.getDeclaredConstructor();
		privateConstructor.setAccessible(true);
		Entity defaultE = (Entity) privateConstructor.newInstance();
		System.out.println(defaultE.getVal() + " " + defaultE.getType());

	}

}
