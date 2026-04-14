package main;

import java.sql.SQLException;
import java.util.Scanner;

import managers.ConnectionManager;

public class Main {
	private Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		new ConnectionManager();
	}

	private void displayChoice(){
        int choice = 0;
        while(choice != 5){
        	
        
            System.out.println("1. Add a new data entry");
            System.out.println("2. Display data based on user choices");
            System.out.println("3. Modify existing data");
            System.out.println("4. remove data from system");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addClient();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    readData();
                    break;
                case 4:
                    viewMembersAndClasses();
                    break;
                case 5:
                    disconnect();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }

    public void addClient(){
		System.out.println("Adding an ID...");
		String id = scanner.nextLine();

		System.out.println("Adding a first_name...");
		String firstName = Scanner.nextLine();

		System.out.println("Enter last_name: ");
		String lastName = Scanner.nextLine();

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

			switch (choice) {
				case 1:
					String sql = "SELECT * FROM employee";
					break;
				case 2:
					String sql = "SELECT * FROM client";
					break;
				case 3:
					String sql = "SELECT * FROM equipment";
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
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
