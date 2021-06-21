package com.udemy.fields.teste;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.udemy.fields.model.Movie;

public class TestandoSuperClass2 {

	public static void main(String[] args) {
		List<Field> allFields = getAllFields(Movie.class);
		
		allFields.stream()
			.map(Field::getName)
			.forEach(System.out::println);
	}

    private static List<Field> getAllFields(Class<?> clazz) {
        if (clazz == null || clazz.equals(Object.class)) {
            return Collections.emptyList();
        }

        Field[] currentClassFields = clazz.getDeclaredFields();

        List<Field> inheritedFields = getAllFields(clazz.getSuperclass());

        List<Field> allFields = new ArrayList<>();

        allFields.addAll(Arrays.asList(currentClassFields));
        allFields.addAll(inheritedFields);

        return allFields;
    }
}
