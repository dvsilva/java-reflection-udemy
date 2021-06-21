package com.udemy.ex2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.udemy.ex1.Cache;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method getCacheSizeMethod = Cache.class.getDeclaredMethod("getCacheSize");
		Class<?> methodReturnType = getCacheSizeMethod.getReturnType();
		System.out.println(methodReturnType.getSimpleName());
		
		// invocation test
		Cache cache = new Cache();
		Object result = getCacheSizeMethod.invoke(cache);
		System.out.println(result);
		System.out.println(result.getClass());
	}

}
