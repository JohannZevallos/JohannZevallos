package com.cibertec.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

	private static String driver = "com.mysql.jdbc.Driver";	
	
	private static String database ="dbcursos";	
	
	private static String host = "localhost";
	
	private static String port = "3306";
	
	private static String urL = "jdbc:mysql://" + host + ":" + port + "/" + database + "?characterEncoding=latin1";
	
	private static String username = "cibertec";
	
	private static String password = "mysql@2023.com";

	public Connection conectarMySQL() {
		Connection cn = null;
		try {
			Class.forName(driver);
			cn = DriverManager.getConnection(urL, username, password);
			if(cn !=null) {
				System.out.println("Coneccion Satisfactoria");
			}else {
				System.out.println("Coneccion No Satisfactoria");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
}
