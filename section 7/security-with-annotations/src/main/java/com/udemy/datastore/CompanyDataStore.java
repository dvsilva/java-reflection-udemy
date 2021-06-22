package com.udemy.datastore;

import com.udemy.annotations.Annotations.OperationType;
import com.udemy.annotations.Annotations.Permissions;
import com.udemy.annotations.Annotations.Role;
import com.udemy.model.User;

@Permissions(role = Role.CLERK, allowed = OperationType.READ)
@Permissions(role = Role.MANAGER, allowed = {OperationType.READ, OperationType.WRITE})
@Permissions(role = Role.SUPPORT_ENGINEER, allowed = {OperationType.READ, OperationType.WRITE, OperationType.DELETE})
public class CompanyDataStore {
    
	private User user;
 
    public void CompanyDataStore(User user) {
        this.user = user;
    }
    
    // Different Database access operations
}