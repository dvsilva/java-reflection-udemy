package com.udemy.restricted.utilities;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import com.udemy.restricted.internal.ImageBuffer;

public class ReflectiveFactory {
 
	public static void main(String[] args) throws Throwable {
		// EXEMPLO 1
		ImageBuffer createObject = createObject(ImageBuffer.class, 200);
		System.out.println(createObject);

		// EXEMPLO 2
		Object argument = new byte[700];
		createObject = createObject(ImageBuffer.class, argument);
		System.out.println(createObject);
		
		// EXEMPLO 3
		createObject = createObject(ImageBuffer.class);
		System.out.println(createObject);
	}
	
    public static <T> T createObject(Class<T> clazz, Object ... args) throws Throwable {
        Class<?>[] parameterTypes = Arrays.stream(args)
                .map(Object::getClass)
                .toArray(Class[]::new);
 
        Constructor<?> constructor = clazz.getDeclaredConstructor(parameterTypes);
        
        // SEM ESSA LINHA EXEMPLOS 2 E 3 LANÇAM EXCEÇÃO
        constructor.setAccessible(true);
        
        return (T) constructor.newInstance(args);
    }
}