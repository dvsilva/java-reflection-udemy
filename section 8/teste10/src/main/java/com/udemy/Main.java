package com.udemy;

/*
 *  MIT License
 *
 *  Copyright (c) 2020 Michael Pogrebinsky - Java Reflection - Master Class
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {
    	DatabaseReader httpClient = createProxy(new DatabaseReaderImpl());
        useDatabaseReader(httpClient);
    }

    public static void useDatabaseReader(DatabaseReader databaseReader) throws InterruptedException {
    	databaseReader.connectToDatabase();
    	
        String costumerId = "";
        try {
        	costumerId = databaseReader.readCustomerIdByName("firstname", "lastname");
        } catch (IOException e) {
            System.out.println("Catching exception " + e);
            return;
        }
        
        System.out.println(String.format("Id find %s into CostumerTable", costumerId));
        
        int rowsInCostumerTable = databaseReader.countRowsInCustomersTable();
        System.out.println(String.format("There are %s rows in CostumerTable", rowsInCostumerTable));
        
        try {
            databaseReader.addCustomer("1", "firstname", "lastname");
        } 
        catch (IOException e) {
            System.out.println("Catching exception " + e);
            return;
        }
     
        Date birthday = databaseReader.readCustomerBirthday("1");
        System.out.println(String.format("birthiday is %s", birthday));
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Object originalObject) {
        Class<?>[] interfaces = originalObject.getClass().getInterfaces();

        CachingInvocationHandler timeMeasuringProxyHandler = new CachingInvocationHandler(originalObject);

        return (T) Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), interfaces, timeMeasuringProxyHandler);
    }
    
}