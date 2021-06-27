package com.basicsstrong.annotation;

class Parent {

	public void m1() {
		System.out.println(" m1 Parent Implementation");
	}

	@Deprecated(since = "2")
	public void m2(int a) {
		System.out.println(" m2 Parent Implementation, a is : " + a);
	}

}