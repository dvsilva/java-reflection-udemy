package com.basicsstrong.annotation;

import com.basicsstrong.annotation.examples.NonEmpty;
import com.basicsstrong.annotation.examples.ReadOnly;

public class Enhancements {

	public static void main(String[] args) {
		
		Box<String> box = new @NonEmpty @ReadOnly Box<>(10, "Container");
		
		box.new @ReadOnly NestedBox(11, "Cylinder");

	}

}

