package com.pcsistemas.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private final static String DRIVER = "org.postgresql.Driver";
	private final static String URL = "jdbc:postgresql://localhost:5432/pcsistemas";
	private final static String USER = "postgres";
	private final static String PASSWORD = "senac";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			System.out.print("Erro ao conectar no BD!" + e.getMessage());
			return null;
		}
	}
}
