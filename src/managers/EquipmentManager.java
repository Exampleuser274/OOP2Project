package managers;

import java.sql.*;
import java.util.Scanner;

import data.Equipment;

public class EquipmentManager {
	public EquipmentManager() {}//Constructor
	public void menu(Scanner scanner, Connection conn) {
		boolean equipLoop = true;
		int equipmentInt;
		while(equipLoop) {
			System.out.println("Please select an option:");
			System.out.println("1. Add equipment");
			System.out.println("2. Search for equipment by ID");
			System.out.println("3. Modify equipment");
			System.out.println("4. Remove equipment");
			System.out.println("5. Return to previous menu");
			while (!scanner.hasNextInt()) {
			    System.out.println("Please Enter a valid input");
			    scanner.next();
			}//scanner check
			equipmentInt = scanner.nextInt();
			scanner.nextLine();
			switch(equipmentInt) {
			case 1:
				AddEquipment(scanner,conn);
				break;
			case 2:
				searchEquipment(scanner,conn);
				break;
			case 3:
				updateEquipment(scanner,conn);
				break;
			case 4:
				removeEquipment(scanner,conn);
				break;
			case 5:
				equipLoop=false;
				break;
			default:
				System.out.println("Error. Enter 1 to 5");
			}//case
		}//menu Loop
	}//menu function

	private void AddEquipment(Scanner scanner,Connection conn) { 
		System.out.println("Enter ID: ");
		while (!scanner.hasNextInt()) {
		    System.out.println("Please Enter a valid input");
		    scanner.next();
		}//scanner check
		int newInt = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter Status: ");
		String newStatus = scanner.nextLine();
		String sql = "INSERT INTO equipment (id,name,status) VALUES(?,?,?)";
		try {
			//stmt.executeUpdate(sql);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, newInt);
			pst.setString(2, newName);
			pst.setString(3, newStatus);
			int count = pst.executeUpdate();
			System.out.println(count + "record(s) inserted");
		} catch (SQLException e) {
			System.out.println("Error adding student: " + e.getMessage());
		}
		
	}//AddEquipment
	
	private void searchEquipment(Scanner scanner, Connection conn) {
		System.out.println("Enter ID: ");
		while (!scanner.hasNextInt()) {
		    System.out.println("Please Enter a valid input");
		    scanner.next();
		}//scanner check
		int searchID = scanner.nextInt();
		scanner.nextLine();
		String sql = "SELECT * FROM equipment WHERE id = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, searchID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String status = rs.getString("status");
				Equipment eq = new Equipment(id,name,status);
				System.out.println(eq);
			}else {
				System.out.println("There is no equipment with ID: " + searchID);
			}
		} catch (SQLException e) {
			System.out.println("Error while retrieving data: " + e.getMessage());
		}
		
	}//SearchEquipment end


	private void updateEquipment(Scanner scanner, Connection conn) {
		System.out.println("Enter ID: ");
		while (!scanner.hasNextInt()) {
		    System.out.println("Please Enter a valid input");
		    scanner.next();
		}//scanner check
		int searchID = scanner.nextInt();
		scanner.nextLine();
		String sql = "SELECT * FROM equipment WHERE id = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, searchID);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()==false) {
				System.out.println("There is no equipment with ID: " + searchID);
			}else {
				System.out.println("Enter Name: ");
				String newName = scanner.nextLine();
				System.out.println("Enter Status: ");
				String newStatus = scanner.nextLine();
				sql = "UPDATE equipment SET name = ?, status = ? WHERE id = ?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,newName);
					pst.setString(2,newStatus);
					pst.setInt(3, searchID);
					pst.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Error while retrieving data: " + e.getMessage());
				}	
			}
		} catch (SQLException e) {
			System.out.println("Error while retrieving data: " + e.getMessage());
		}	
	}//UpdateEquipment end
	
	private void removeEquipment(Scanner scanner, Connection conn) {
		System.out.println("Enter ID: ");
		while (!scanner.hasNextInt()) {
		    System.out.println("Please Enter a valid input");
		    scanner.next();
		}//scanner check
		int removeID = scanner.nextInt();
		scanner.nextLine();
		String sql = "SELECT * FROM equipment WHERE id = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, removeID);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()==false) {
				System.out.println("There is no equipment with ID: " + removeID);
			}else {
				sql = "DELETE FROM equipment WHERE id = ?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, removeID);
					pst.executeUpdate();
					System.out.println("Equipment removed");
				} catch (SQLException e) {
					System.out.println("Error removing equipment record: " + e.getMessage());
				}
			}
		} catch (SQLException e) {
			System.out.println("Error while retrieving data: " + e.getMessage());
		}	
	}//RemoveEquipment



	
}//Class
