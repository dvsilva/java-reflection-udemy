package com.basicsstrong.practice.orm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.basicsstrong.orm.annotation.PrimaryKey;
import com.basicsstrong.ormannotation.Column;

public class Hibernate<T> {

	private Connection con;

	private AtomicLong id = new AtomicLong(0L);

	public static <T> Hibernate<T> getConnection() throws Exception {
		return new Hibernate<T>();
	}

	private Hibernate() throws SQLException, InterruptedException {
		this.con = DriverManager.getConnection("jdbc:h2:.//src//main//resources//database//my-database", "sa", "");
//		this.con = DriverManager.getConnection("jdbc:h2:C:\\Projetos\\outros\\reflections-annotation-uncomplicated\\custom-orm\\src\\main\\resources\\database\\practice1", "sa", "");
	}

	public void write(T t) throws IllegalArgumentException, IllegalAccessException, SQLException {
		Class<? extends Object> clss = t.getClass();

		Field[] declaredFields = clss.getDeclaredFields();

		Field pkey = null;

		List<Field> columns = new ArrayList<>();
		StringJoiner joiner = new StringJoiner(",");

		for (Field field : declaredFields) {
			field.setAccessible(true);
			
			if (field.isAnnotationPresent(PrimaryKey.class)) {
				pkey = field;
				System.out.println("The Primary Key is : " + field.getName() + " value :" + field.get(t));
			} 
			else if (field.isAnnotationPresent(Column.class)) {
				joiner.add(field.getName());
				columns.add(field);
				System.out.println("Columns found is: " + field.getName() + " value : " + field.get(t));
			}
		}

		int number = columns.size() + 1;

		String qMarks = IntStream.range(0, number)
				.mapToObj(e -> "?")
				.collect(Collectors.joining(","));
		
//		System.out.println(qMarks);
//		System.out.println(joiner.toString());

		String sql = "insert into " + clss.getSimpleName() + "(" + pkey.getName() + "," + joiner.toString() + ") "
				+ "values (" + qMarks + ");";
//				+ "values (?,?,?,?,?);";
		
		System.out.println(sql);

		PreparedStatement stmt = con.prepareStatement(sql);

		if (pkey.getType() == long.class) {
			stmt.setLong(1, id.incrementAndGet());
		}

		int index = 2;
		for (Field field : columns) {
			field.setAccessible(true);
			
			if (field.getType() == int.class) {
				stmt.setInt(index++, (int) field.get(t));
			} 
			else if (field.getType() == String.class) {
				stmt.setString(index++, (String) field.get(t));
			}
		}

		stmt.executeUpdate();

	}

	public T read(Class<T> clss, long l) throws SQLException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		Field[] declaredFields = clss.getDeclaredFields();

		Field pkey = null;
		for (Field field : declaredFields) {
			if (field.isAnnotationPresent(PrimaryKey.class)) {
				pkey = field;
				break;
			}
		}

		String sql = "select * from " + clss.getSimpleName() + " where " + pkey.getName() + " = " + l;

		PreparedStatement stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		rs.next();

		T t = clss.getConstructor().newInstance();

		long transactionId = rs.getInt(pkey.getName());
		pkey.setAccessible(true);
		pkey.set(t, transactionId);

		for (Field field : declaredFields) {
			if (field.isAnnotationPresent(Column.class)) {
				field.setAccessible(true);

				if (field.getType() == int.class) {
					field.set(t, rs.getInt(field.getName()));
				} 
				else if (field.getType() == String.class) {
					field.set(t, rs.getString(field.getName()));
				}
			}
		}
		
		return t;
	}
}
