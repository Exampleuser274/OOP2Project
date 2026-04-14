package main;

import java.sql.*;
import java.util.Scanner;

import managers.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ConnectionManager connectionManager = new ConnectionManager();
		Connection conn = connectionManager.connect();
		UIManager uiManager = new UIManager();
		EquipmentManager equip = new EquipmentManager();
		AccountManager account = new AccountManager();
		uiManager.Menu(scanner, conn,equip,account);
		scanner.close();
		connectionManager.disconnect();
	}
/*
    public void addClient(){
		System.out.println("Adding an ID...");
		String id = scanner.nextLine();

		System.out.println("Adding a first_name...");
		String firstName = scanner.nextLine();

		System.out.println("Enter last_name: ");
		String lastName = scanner.nextLine();

		System.out.println("Enter membership_status: ");
		boolean membershipStatus = Boolean.parseBoolean(scanner.nextLine());

		System.out.println("Enter member_type: ");
		String memberType = scanner.nextLine();

		String sql = String.format("INSERT INTO client (id, first_name, last_name, membership_status, member_type) VALUES ('%s', '%s', '%s', '%s', '%s')", id, firstName, lastName, membershipStatus, memberType);
	}

	public void addEmployee(){
		System.out.println("Adding an ID...");
		String id = scanner.nextLine();

		System.out.println("Adding a first_name...");
		String firstName = scanner.nextLine();

		System.out.println("Enter last_name: ");
		String lastName = scanner.nextLine();

		System.out.println("Enter employee_type: ");
		String employeeType = scanner.nextLine();


		String sql = String.format("INSERT INTO employee (id, first_name, last_name, employee_type) VALUES ('%s', '%s', '%s', '%s')", id, firstName, lastName, employeeType);
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,id);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, employeeType);
			int count = pst.executeUpdate();
			System.out.println(count + " Record(s) inserted.");
		} catch (SQLException e) {
			System.out.println("Error while adding Employee: " + e.getMessage());
		}
	}


	public void readData(){
		int choice = 0;
		while(choice != 3){
			System.out.println("1. View all employees");
			System.out.println("2. View all clients");
			System.out.println("3. view all equipments");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline
			String sql = "";
			switch (choice) {
				case 1:
					sql = "SELECT * FROM employee";
					break;
				case 2:
					sql = "SELECT * FROM client";
					break;
				case 3:
					sql = "SELECT * FROM equipment";
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
	
	public void viewMembersAndClasses() {
		
	}

	public void deleteData(){
		int choice = 0;
		while(choice != 3){
			System.out.println("1. Delete from employees using ID");
			System.out.println("2. Delete from clients using ID");
			System.out.println("3. Delete from equipment using ID");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					System.out.println("Enter employee ID to delete: ");
					int employeeId = scanner.nextInt();
					scanner.nextLine(); // Consume newline
					String sql = "DELETE FROM employee WHERE employee_id = " + employeeId;
					break;
				case 2:
					System.out.println("Enter client ID to delete: ");
					int clientId = scanner.nextInt();
					scanner.nextLine(); // Consume newline
					 sql = "DELETE FROM client WHERE client_id = " + clientId;
					break;
				case 3:
					System.out.println("Enter equipment ID to delete: ");
					int equipmentId = scanner.nextInt();
					scanner.nextLine(); // Consume newline
					 sql = "DELETE FROM equipment WHERE equipment_id = " + equipmentId;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
			
			
			
			String sql = "DELETE FROM students WHERE student_id = ?";

		}
	}



    
*/
}
