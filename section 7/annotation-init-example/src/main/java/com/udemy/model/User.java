package com.udemy.model;

import java.util.concurrent.TimeUnit;

import com.udemy.annotations.Permission;

@Permission(role = Permission.Role.BY_PASSWORD_AND_ID, 
        timeBetweenAccess = 10, 
        timeBetweenAccessUnits = TimeUnit.SECONDS)  
public class User {

}
