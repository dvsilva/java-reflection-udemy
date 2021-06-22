package com.udemy.infraestructure;

import com.udemy.annotations.OpenResources;

public class DatabaseFactory {
	
	@OpenResources
	public void openDatabaseConnection() {
		System.out.println("openning database connection ...");
	}

	@OpenResources
	public void openProperties() {
		System.out.println("openning properties ...");
	}

}
