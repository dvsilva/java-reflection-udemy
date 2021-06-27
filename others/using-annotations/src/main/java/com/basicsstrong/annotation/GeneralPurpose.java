package com.basicsstrong.annotation;

import java.util.ArrayList;

public class GeneralPurpose extends Parent {

	@Override
	public void m1() {
		System.out.println("m1 Child Implementation");
	}

	public static void main(String[] args) {
		int a = 10;

		@SuppressWarnings({ "rawtypes", "unused" })
		ArrayList aList = new ArrayList();

		GeneralPurpose obj = new GeneralPurpose();
		obj.m2(a);

		Integer i = new Integer(0);

		MyFuctionalInterface impl = () -> System.out.println("Method invoked");

		impl.method();
	}

}
