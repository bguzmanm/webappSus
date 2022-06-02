package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection connection = null;
	
	private Conexion() {
		try {
			
			//Class.forName("oracle.jdbc.driver.OracleDriver"); //para Oracle
			Class.forName("com.mysql.jdbc.Driver"); //para MySQL
			
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "OT", "kupita"); //para Oracle
			
			connection = DriverManager.getConnection("jdbc:mysql://192.168.64.2:3306/sakila", "brian", "kupita"); // para MySQL
			
		} catch (ClassNotFoundException | SQLException e) {	
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if (connection==null) {
			new Conexion();
		}
		
		return connection;
	}
	
	
 	
}
