package com.udemy.annotations;

import java.util.concurrent.TimeUnit;

public @interface Permission {
	
    Role role();
    int timeBetweenAccess() default 60;
    TimeUnit timeBetweenAccessUnits() default TimeUnit.MINUTES;
    
    enum Role {
        OPEN,
        BY_PASSWORD_ONLY,
        BY_PASSWORD_AND_ID
    }
}