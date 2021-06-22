package com.udemy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.udemy.external.DatabaseConnection;

public class LoggingInvocationHandler implements InvocationHandler {

	private final DatabaseConnection realDatabaseConnection;

	public LoggingInvocationHandler(DatabaseConnection realDatabaseConnection) {
		this.realDatabaseConnection = realDatabaseConnection;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(String.format("Method: %s. Args : %s", method.getName(), Arrays.asList(args)));

		return method.invoke(realDatabaseConnection, args);
	}
}