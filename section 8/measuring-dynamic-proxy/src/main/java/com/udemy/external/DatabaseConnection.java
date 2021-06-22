package com.udemy.external;

import java.io.IOException;

public interface DatabaseConnection {
	
    String readCustomerName(String id) throws IOException;
 
    void addConsumer(String id, String name);
    
}