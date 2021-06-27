package com.basicsstrong.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.basicsstrong.annotation.examples.MostUsed;
import com.basicsstrong.annotation.util.Utility;

public class ReadingAnnotation {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class<?> clss = Class.forName("com.basicsstrong.annotation.Utility");
		Constructor<?> constructor = clss.getConstructor();
		Utility u = (Utility) constructor.newInstance();
		
		Method[] methods = clss.getDeclaredMethods();
		
		for (Method method : methods) {
			if(method.isAnnotationPresent(MostUsed.class)) {
				
				MostUsed annotation = method.getAnnotation(MostUsed.class);
				String value = annotation.value();
				method.invoke(u, value);
			}
		}
	}

}
