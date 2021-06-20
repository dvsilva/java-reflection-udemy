package com.udemy.ra;

import java.lang.reflect.*;

public class ArrayReader {

	public static void main(String[] args) {
		int[] input = new int[] { 0, 10, 20, 30, 40 };
		System.out.println(getArrayElement(input, 3));

		String[] names = new String	[] { "Jhon", "Michael", "Joe", "David" };
		System.out.println(getArrayElement(names, -1));
		System.out.println(getArrayElement(names, 0));
	}

	public static Object getArrayElement(Object array, int index) {
		Class<?> clazz = array.getClass();
		System.out.println(String.format("Is array : %s", clazz.isArray()));

		 if (index >= 0) {
            return Array.get(array, index);
        }
		 
        int arrayLength = Array.getLength(array);
        return Array.get(array, arrayLength + index);
	}
}