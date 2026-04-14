package managers;

import java.sql.*;

import java.util.Scanner;

public class ConnectionManager {

    private Connection conn = null;
    private Scanner scanner = new Scanner(System.in);
	
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "gymmanageproject";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";


    //establishes connection to the db
    public Connection connect() {
		final String DB_URL = String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s", 
				SERVER, PORT, DATABASE, USERNAME, PASSWORD);
		
		//System.out.println(DB_URL);
		try {
			conn = DriverManager.getConnection(DB_URL);
			System.out.println("DB connection established");
		}catch(SQLException e) {
			System.out.println("Problem connecting to DB: " + e.getMessage());
		}
		return conn;
	}

    public void disconnect(){
        try{
            conn.close();
            scanner.close();
            System.out.println("DB connection closed");
        }catch (SQLException e){
            System.out.println("Problem disconnecting from DB: " + e.getMessage());
        }
    }
}
