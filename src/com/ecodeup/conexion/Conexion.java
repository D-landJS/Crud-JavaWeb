package com.ecodeup.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

;


public class Conexion {
	private static BasicDataSource dataSource=null;
	
	private static DataSource getDataSource() {
		if (dataSource==null) {
			dataSource= new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("Administrador");
			dataSource.setUrl("jdbc:mysql://localhost:3306/parking?"
					+ "verifyServerCertificate=false&useSSL=false"
					+ "&serverTimezone=UTC");
			System.out.print("hay conexion");
			
		}
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
		
	}
}
