package com.basicsstrong.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.basicsstrong.reflection.model.Entity;

public class ModifierInfo {

	public static void main(String[] args) throws Exception {

		Entity e = new Entity(10, "id");
		Class<? extends Entity> clss = e.getClass();
		int modifiersInt = clss.getModifiers();


		int isPublic = modifiersInt & Modifier.PUBLIC;
		System.out.println(isPublic);
		
		boolean isPublicClass = Modifier.isPublic(modifiersInt);
		System.out.println(isPublicClass);
		
		System.out.println(Modifier.toString(modifiersInt));

		
		Method method = clss.getMethod("getVal");
		int methodModifiers = method.getModifiers();
		System.out.println(methodModifiers);

		boolean ispubMethod = Modifier.isPublic(methodModifiers);
		System.out.println(ispubMethod);

		System.out.println(Modifier.toString(methodModifiers));

	}

}
