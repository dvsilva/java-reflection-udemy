package com.udemy;

import com.udemy.annotations.Annotations.Role;
import com.udemy.datastore.CompanyDataStore;
import com.udemy.model.AccountRecord;
import com.udemy.model.User;

public class Main {

	public static void main(String[] args) throws Throwable {
		User user = new User();
//		user.setRole(Role.CLERK);
//		user.setRole(Role.MANAGER);
		user.setRole(Role.SUPPORT_ENGINEER);

		CompanyDataStore companyDataStore = new CompanyDataStore(user);
		
		System.out.println("readAccounts");
		companyDataStore.readAccounts(new String[] { "1", "2", "3" });
		System.out.println("readAccounts");

		System.out.println("updateAccount");
		companyDataStore.updateAccount("1", new AccountRecord());
		System.out.println("updateAccount");

		System.out.println("readAccountSummary");
		companyDataStore.readAccountSummary(Role.MANAGER, "1");
		System.out.println("readAccountSummary");

		System.out.println("deleteAccount");
		companyDataStore.deleteAccount("1");
		System.out.println("deleteAccount");
	}

}
