package com.udemy.fields.teste;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.udemy.fields.model.Movie;

public class TestandoSuperClass {

	public static void main(String[] args) {
		allFieldsFor(Movie.class)
			.map(Field::getName)
			.forEach(System.out::println);
	}

	private static <T> Stream<Field> allFieldsFor(Class<T> c) {
		return walkInheritanceTreeFor(c)
				.flatMap(k -> Arrays.stream(k.getDeclaredFields()));
	}

	private static <T> Stream<Class> walkInheritanceTreeFor(Class<T> c) {
		return iterate(c, k -> Optional.ofNullable(k.getSuperclass()));
	}

	private static <T> Stream<T> iterate(T seed, Function<T, Optional<T>> fetchNextFunction) {
		Objects.requireNonNull(fetchNextFunction);

		Iterator<T> iterator = new Iterator<T>() {
			private Optional<T> t = Optional.ofNullable(seed);

			public boolean hasNext() {
				return t.isPresent();
			}

			public T next() {
				T v = t.get();
				t = fetchNextFunction.apply(v);
				return v;
			}
		};

		Spliterator<T> spliteratorUnknownSize = Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED | Spliterator.IMMUTABLE);
		return StreamSupport.stream(spliteratorUnknownSize, false);
	}
}
