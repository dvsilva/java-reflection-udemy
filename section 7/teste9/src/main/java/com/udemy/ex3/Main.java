package com.udemy.ex3;

import com.udemy.ex3.Annotations.Viawable;
import com.udemy.ex3.Annotations.Viawable.DeviceType;

public class Main {

	public static void main(String[] args) {
		System.out.println("testAnotation");
		testAnotation(new SmallUiHomePage());
		testAnotation(new UiHomePage());

		System.out.println("testRepetedAnotation");
		testRepetedAnotation(new SmallUiHomePage());
		testRepetedAnotation(new UiHomePage());
	}

	private static void testRepetedAnotation(Object obj) {
		Class<?> pageClass = obj.getClass();

		Viawable[] annotationsByType = pageClass.getAnnotationsByType(Viawable.class);

		for (Viawable annotation : annotationsByType) {
			DeviceType deviceType = annotation.deviceType();
			int width = annotation.width();
			int height = annotation.height();

			System.out.println(pageClass + ": " + deviceType + " - " + width + " - " + height);
		}
	}

	private static void testAnotation(Object obj) {
		Class<?> pageClass = obj.getClass();

		if (pageClass.isAnnotationPresent(Viawable.class)) {
			Viawable annotation = UiHomePage.class.getAnnotation(Viawable.class);
			DeviceType deviceType = annotation.deviceType();
			int width = annotation.width();
			int height = annotation.height();

			System.out.println(deviceType);
			System.out.println(width);
			System.out.println(height);
		}
	}

}
