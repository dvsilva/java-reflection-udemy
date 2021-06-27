package com.basicsstrong.methodhandles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;

public class MethodHandlesDemo {

	public static void main(String[] args) throws Throwable {
		Lookup lookup = MethodHandles.lookup();
		Class<?> clss = lookup.findClass(Student.class.getName());

		MethodType methodType = MethodType.methodType(String.class);

		Student s = new Student();
		s.setCourse("Java");

		MethodHandle getCourseHandle = lookup.findVirtual(clss, "getCourse", methodType);

		System.out.println(getCourseHandle.invoke(s));
		System.out.println("===========================");

		MethodType type = MethodType.methodType(void.class);
		MethodHandle noArgHandle = lookup.findConstructor(clss, type);
		
		Student student = (Student) noArgHandle.invoke();
		student.setName("Meenal");
		student.setCourse("Scala");
		System.out.println(student.toString());
		
		System.out.println("===========================");

		MethodType type1 = MethodType.methodType(void.class, String.class, String.class);
		MethodHandle paraCons = lookup.findConstructor(clss, type1);
		Student divya = (Student) paraCons.invoke("Divya", "Python");
		System.out.println(divya.toString());

		System.out.println("===========================");

		MethodType methodType2 = MethodType.methodType(void.class, String.class);
		MethodHandle setNameHandle = lookup.findVirtual(clss, "setName", methodType2);
		setNameHandle.invoke(student, "Mohit");
		System.out.println(student.getName());

		System.out.println("===========================");

		MethodType methodType3 = MethodType.methodType(void.class, int.class);
		MethodHandle setNumOfStudentsHandle = lookup.findStatic(clss, "setNumOfStudents", methodType3);
		setNumOfStudentsHandle.invoke(2);
		System.out.println(student.getNumOfStudents());

//		System.out.println("===========================");
//
		// ERROR - java.lang.IllegalAccessException: member is private
//		MethodHandle findGetter = lookup.findGetter(clss, "name", String.class);
//		findGetter.invoke(student);
//		
//		MethodHandle findSetter = lookup.findSetter(clss, "name", String.class);
//		findSetter.invoke(student, "Justin");
//		System.out.println(student.getName());
//		
		System.out.println("===========================");
		
		Lookup privateLookupIn = MethodHandles.privateLookupIn(clss, lookup);

		MethodHandle findGetter = privateLookupIn.findGetter(clss, "name", String.class);
		System.out.println(findGetter.invoke(student));
		
		MethodHandle findSetter = privateLookupIn.findSetter(clss, "name", String.class);
		findSetter.invoke(student, "Justin");
		System.out.println(student.getName());

		System.out.println("===========================");

		VarHandle courseVarHandle = privateLookupIn.findVarHandle(clss, "course", String.class);
		String val = (String) courseVarHandle.get(student);
		System.out.println(val);
		courseVarHandle.set(student, "Kotlin");
		val = (String) courseVarHandle.get(student);
		System.out.println(val);
	}

}
