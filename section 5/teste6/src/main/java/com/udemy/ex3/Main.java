package com.udemy.ex3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.udemy.ex1.Cache;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Cache cache = new Cache();
		Method getCacheSizeMethod = Cache.class.getDeclaredMethod("getCacheSize");
		 
		Class<?> methodReturnType = getCacheSizeMethod.invoke(cache).getClass();
		System.out.println(methodReturnType.getSimpleName());
	}

}
