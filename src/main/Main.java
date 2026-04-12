package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {


	static Connection conn = null;
	static Statement stmt = null;
	
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	public static void main(String[] args) {
		
	//connect to the database
	connect();

	}

	public static void connect() {
		final String DB_URL = String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s", 
				SERVER, PORT, DATABASE, USERNAME, PASSWORD);
		
		//System.out.println(DB_URL);
		try {
			conn = DriverManager.getConnection(DB_URL);
			System.out.println("DB connection established");
			stmt = conn.createStatement();
			
		}catch(SQLException e) {
			System.out.println("Problem connecting to DB: " + e.getMessage());
		}
	}

	public static void displayAll(){
		String sql = "";
		//im going to add the db name here.
	}

}
