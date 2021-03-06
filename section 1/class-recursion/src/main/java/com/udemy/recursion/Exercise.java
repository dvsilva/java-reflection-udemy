package com.udemy.recursion;
import java.util.*;

public class Exercise {

	public static void main(String[] args) {
		Set<Class<?>> findAllImplementedInterfaces = findAllImplementedInterfaces(ArrayList.class);
		findAllImplementedInterfaces.forEach(System.out::println);
	}
	
    /**
     * Returns all the interfaces that the current input class implements.
     * Note: If the input is an interface itself, the method returns all the interfaces the 
     * input interface extends.
     */
    public static Set<Class<?>> findAllImplementedInterfaces(Class<?> input) {
        Set<Class<?>> allImplementedInterfaces = new HashSet<>();
 
        Class<?>[] inputInterfaces = input.getInterfaces();
        
        for (Class<?> currentInterface : inputInterfaces) {
            allImplementedInterfaces.add(currentInterface);
            allImplementedInterfaces.addAll(findAllImplementedInterfaces(currentInterface));
        }
 
        return allImplementedInterfaces;
    }
}