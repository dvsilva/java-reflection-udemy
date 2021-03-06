package com.basicsstrong.annotation;

import com.basicsstrong.annotation.examples.MostUsed;

public class Utility {

	void doStuff() {
		System.out.println("Doing something.");
	}

	@MostUsed("Python")
	void doStuff(String arg) {
		System.out.println("Operating on : " + arg);
	}

	void doStuff(int i) {
		System.out.println("Operating on : " + i);
	}

}

class SubUtility extends Utility {

}
