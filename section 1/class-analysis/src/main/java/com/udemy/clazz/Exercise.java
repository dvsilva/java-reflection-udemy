package com.udemy.clazz;
import java.util.ArrayList;
 
public class Exercise {
	
     public static void main(String[] args) {
		Class<?> inputClass = new ArrayList<String>().getClass();
		PopupTypeInfo popupTypeInfo = ClassAnalyzer.createPopupTypeInfoFromClass(inputClass);
		printInfo(popupTypeInfo);
		
		inputClass = new Product().getClass();
		popupTypeInfo = ClassAnalyzer.createPopupTypeInfoFromClass(inputClass);
		printInfo(popupTypeInfo);
		
		inputClass = int.class;
		popupTypeInfo = ClassAnalyzer.createPopupTypeInfoFromClass(inputClass);
		printInfo(popupTypeInfo);
	}

	private static void printInfo(PopupTypeInfo popupTypeInfo) {
//		System.out.println("================== print new  data ==================");
		System.out.println(popupTypeInfo);
		
//		System.out.println("isPrimitive " + popupTypeInfo.isPrimitive());
//		System.out.println("isInterface " + popupTypeInfo.isInterface());
//		System.out.println("isEnum " + popupTypeInfo.isEnum());
//		System.out.println("getName " + popupTypeInfo.getName());
//		System.out.println("isJdk " + popupTypeInfo.isJdk());
//		System.out.println("getInheritedClassNames " + popupTypeInfo.getInheritedClassNames());
	}
     
 }