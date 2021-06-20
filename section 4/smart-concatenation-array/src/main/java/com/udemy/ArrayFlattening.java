package com.udemy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayFlattening {

	public static void main(String[] args) {
		Integer[] result1 = (Integer[]) concat(1, 2, 3, 4, 5);
		printArray(result1);

		Integer[] result2 = (Integer[]) concat(1, 2, 3, new int[] { 4, 5, 6 }, 7);
		printArray(result2);

		String[] result3 = (String[]) concat(new String[] { "a", "b" }, "c", new String[] { "d", "e" });
		printArray(result3);
	}

	private static void printArray(Object[] result) {
		for (Object value : result) {
			System.out.println(value);
		}
		
		System.out.println("===========================");
	}

	public static Object concat(Object ... arguments) {
        if (arguments.length == 0) {
            return null;
        }
 
        Class<?> type = arguments[0].getClass().isArray()
                ? arguments[0].getClass().getComponentType()
                : arguments[0].getClass();
 
        List<Object> elements = new ArrayList<>();
        
        for (Object argument : arguments) {
            if (argument.getClass().isArray()) {
                int length = Array.getLength(argument);
 
                for (int i = 0 ; i < length ; i++) {
                    elements.add(Array.get(argument, i));
                }
            } else {
                elements.add(argument);
            }
        }
 
        Object flattenedArray = Array.newInstance(type, elements.size());
 
        for (int i = 0; i <elements.size() ; i++) {
            Array.set(flattenedArray, i, elements.get(i));
        }
 
        return flattenedArray;
    }
	
}