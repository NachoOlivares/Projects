package com.extendedDnD.locator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AuthLocator {
	
	private static final String str = "jdbc:mysql://localhost:3306/dnd?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT\"";
	private static final String user = "root";
	private static final String pwd = "";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName ("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(str, user, pwd);

	}
}
