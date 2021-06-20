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

package com.udemy.fields;

import java.lang.reflect.Field;

import com.udemy.fields.model.Category;
import com.udemy.fields.model.Movie;
import com.udemy.fields.model.Movie.MovieStats;

/**
 * Introduction to Fields
 * https://www.udemy.com/course/java-reflection-master-class
 */
public class Main {

	public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
		printDeclaredFieldsInfo(Movie.class);
		System.out.println("===========================");	
		
		printFieldsInfo(Movie.class);
		System.out.println("===========================");

		printDeclaredFieldsInfo(MovieStats.class);
		System.out.println("===========================");

		printDeclaredFieldsInfo(Category.class);
		System.out.println("===========================");

		Movie movie = new Movie("Lord of the Rings", 2001, 12.99, true, Category.ADVENTURE);

		printDeclaredFieldsInfo(Movie.class, movie);
		System.out.println("===========================");

		Field minPriceStaticField = Movie.class.getDeclaredField("MINIMUM_PRICE");
		System.out.println(String.format("static MINIMUM_PRICE value: %f", minPriceStaticField.get(null)));
	}

	public static <T> void printDeclaredFieldsInfo(Class<? extends T> clazz) {
		for (Field field : clazz.getDeclaredFields()) {
			System.out.println(String.format("Field name : %s type : %s", field.getName(), field.getType().getName()));
			System.out.println(String.format("Is synthetic field : %s", field.isSynthetic()));
		}
	}	
	
	public static <T> void printFieldsInfo(Class<? extends T> clazz) {
		for (Field field : clazz.getFields()) {
			System.out.println(String.format("Field name : %s type : %s", field.getName(), field.getType().getName()));
			System.out.println(String.format("Is synthetic field : %s", field.isSynthetic()));
		}
	}

	public static <T> void printDeclaredFieldsInfo(Class<? extends T> clazz, T instance) throws IllegalAccessException {
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);

			System.out.println(String.format("Field name : %s type : %s", field.getName(), field.getType().getName()));
			System.out.println(String.format("Is synthetic field : %s", field.isSynthetic()));
			System.out.println(String.format("Field value is : %s", field.get(instance)));
		}
	}

}
