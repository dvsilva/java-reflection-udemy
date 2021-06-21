package com.udemy.ex4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.udemy.ex1.Cache;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Cache cache = new Cache();
		Method readIdOrThrowMethod = Cache.class.getDeclaredMethod("readIdOrThrow", String.class);
		 
		Integer id = (Integer) readIdOrThrowMethod.invoke(cache, "Daniel");
		System.out.println(String.format("Daniel's ID is %s", id));
	}

}
