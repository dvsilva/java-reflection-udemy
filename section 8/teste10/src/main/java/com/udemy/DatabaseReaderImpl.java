package com.udemy;

import java.io.IOException;
import java.util.Date;

public class DatabaseReaderImpl implements DatabaseReader {

	@Override
	public void connectToDatabase() {
		System.out.println("executing 'connectToDatabase'");
	}

	@Override
	public String readCustomerIdByName(String firstName, String lastName) throws IOException {
		System.out.println("executing 'readCustomerIdByName'");
		return null;
	}

	@Override
	public int countRowsInCustomersTable() {
		System.out.println("executing 'countRowsInCustomersTable'");
		return 0;
	}

	@Override
	public void addCustomer(String id, String firstName, String lastName) throws IOException {
		System.out.println("executing 'addCustomer'");
//		throw new IOException("Error in method addCustomer");
	}

	@Override
	public Date readCustomerBirthday(String id) {
		System.out.println("executing 'readCustomerBirthday'");
		return null;
	}

}
