package com.udemy.osc;

import java.lang.reflect.Field;

import com.udemy.osc.model.AccountSummary;

public class ObjectSizeCalculator {

	private static final long HEADER_SIZE = 12;
	private static final long REFERENCE_SIZE = 4;

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		AccountSummary accountSummary = new AccountSummary("John", "Smith", (short) 20, 100_000);
		System.out.println(String.format("The size is : %d", sizeOfObject(accountSummary)));
	}

	public static long sizeOfObject(Object input) throws IllegalArgumentException, IllegalAccessException {
		long size = HEADER_SIZE + REFERENCE_SIZE;

		Field[] declaredFields = input.getClass().getDeclaredFields();

		for (Field field : declaredFields) {
			field.setAccessible(true);

			if (field.getType().isPrimitive()) {
				size += sizeOfPrimitiveType(field.getType());
			} else {
				size += sizeOfString((String) field.get(input));
			}

		}

		return size;
	}

	/*************** Helper methods ********************************/
	private static long sizeOfPrimitiveType(Class<?> primitiveType) {
		if (primitiveType.equals(int.class)) {
			return 4;
		} else if (primitiveType.equals(long.class)) {
			return 8;
		} else if (primitiveType.equals(float.class)) {
			return 4;
		} else if (primitiveType.equals(double.class)) {
			return 8;
		} else if (primitiveType.equals(byte.class)) {
			return 1;
		} else if (primitiveType.equals(short.class)) {
			return 2;
		}

		throw new IllegalArgumentException(String.format("Type: %s is not supported", primitiveType));
	}

	private static long sizeOfString(String inputString) {
		int stringBytesSize = inputString.getBytes().length;
		return HEADER_SIZE + REFERENCE_SIZE + stringBytesSize;
	}
}