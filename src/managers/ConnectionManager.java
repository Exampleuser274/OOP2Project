package managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionManager {

    private Connection conn = null;
	private Statement stmt = null;
    private Scanner scanner = new Scanner(System.in);
	
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "gymmanageproject";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";

    public ConnectionManager() {
        connect();
    }

    //establishes connection to the db
    public void connect() {
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


}
