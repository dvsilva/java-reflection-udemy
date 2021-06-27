package com.basicsstrong.reflection;

public class GettingClassObject {

	public static void main(String[] args) throws ClassNotFoundException {

		// forName()
		Class<?> clss1 = Class.forName("java.lang.String");
		Class<?> clss2 = Class.forName("java.lang.String");

		System.out.println(clss1 == clss2);

		// ClassName.class
		Class<?> clss3 = int.class;
		System.out.println(clss3);
		Class<?> clss4 = String.class;
		System.out.println(clss4);

		// obj.getClass()
		MyClass m = new MyClass();
		Class<?> class5 = m.getClass();
		System.out.println(class5);

		// super class
		Class<?> superclass = class5.getSuperclass();
		System.out.println(superclass);

		// interfaces
		Class<?>[] interfaces = class5.getInterfaces();
		System.out.println(interfaces);

		// getName()
		System.out.println(class5.getName());
	}

}
