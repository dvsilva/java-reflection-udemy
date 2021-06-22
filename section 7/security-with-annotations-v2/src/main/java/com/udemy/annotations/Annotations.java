package com.udemy.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotations {

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Repeatable(PermissionsContainer.class)
	public @interface Permissions {
		Role role();
		OperationType[] allowed();
	}

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface PermissionsContainer {
		Permissions[] value();
	}

	public enum Role {
		CLERK, MANAGER, SUPPORT_ENGINEER
	}

	public enum OperationType {
		READ, WRITE, DELETE
	}
	
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface MethodOperations {
		OperationType[] value();
	}

}