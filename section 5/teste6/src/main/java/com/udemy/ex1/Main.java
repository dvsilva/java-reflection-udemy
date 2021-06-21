package com.udemy.ex1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Cache cache = new Cache();
		Method addEntryMethod = Cache.class.getDeclaredMethod("addEntry");
		Object result = addEntryMethod.invoke(cache, "John", 123);
		System.out.println(result);
	}

}
