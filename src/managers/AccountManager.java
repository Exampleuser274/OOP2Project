package managers;
import java.sql.*;
import java.util.Scanner;

import data.*;
public class AccountManager {
	public AccountManager() {
		
	}//constructor
	public void menu(Scanner scanner, Connection conn) {
		boolean accountLoop = true;
		boolean accountSwitch = true;
		int accountInt;
		int accountType = 0;
		while (accountSwitch) {
			System.out.println("Which type of account?");
			System.out.println("1. Client");
			System.out.println("2. Employee");
			while (!scanner.hasNextInt()) {
			    System.out.println("Please Enter a valid input");
			    scanner.next();
			}//scanner check
			accountType = scanner.nextInt();
			scanner.nextLine();
			if (accountType == 1 || accountType == 2) {
				accountSwitch = false;
			}else {
				System.out.println("Error. Enter 1 or 2");
			}//if/else
		}//account type loop
		while(accountLoop) {
			System.out.println("Please select an option:");
			System.out.println("1. Add account");
			System.out.println("2. Search for account by ID");
			System.out.println("3. Modify account");
			System.out.println("4. Remove account");
			System.out.println("5. Return to previous menu");
			while (!scanner.hasNextInt()) {
			    System.out.println("Please Enter a valid input");
			    scanner.next();
			}//scanner check
			accountInt = scanner.nextInt();
			scanner.nextLine();
			switch(accountInt) {
			case 1:
				AddAccount(accountType,scanner,conn);
				break;
			case 2:
				searchAccount(accountType,scanner,conn);
				break;
			case 3:
				updateAccount(accountType,scanner,conn);
				break;
			case 4:
				removeAccount(accountType,scanner,conn);
				break;
			case 5:
				accountLoop=false;
				break;
			default:
				System.out.println("Error. Enter 1 to 5");
			}//case
		}//menu Loop
	}
	private void removeAccount(int accountType,Scanner scanner, Connection conn) {
		String sql;
		System.out.println("Enter ID: ");
		while (!scanner.hasNextInt()) {
		    System.out.println("Please Enter a valid input");
		    scanner.next();
		}//scanner check
		int removeID = scanner.nextInt();
		scanner.nextLine();
		if (accountType==1) {
			sql = "DELETE FROM employee WHERE id = ?";
		}else {
			sql = "DELETE FROM client WHERE id = ?";
		}
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, removeID);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()==false) {
				System.out.println("There is no account with ID: " + removeID);
			}else {
				
				try {
					pst = conn.prepareStatement(sql);
					pst.setInt(1, removeID);
					pst.executeUpdate();
					System.out.println("account removed");
				} catch (SQLException e) {
					System.out.println("Error removing equipment record: " + e.getMessage());
				}
			}
		} catch (SQLException e) {
			System.out.println("Error while retrieving data: " + e.getMessage());
		}
		
	}

	private void updateAccount(int accountType,Scanner scanner, Connection conn) {
		String sql;
		String type;
		String status = null;
		System.out.println("Enter ID: ");
		while (!scanner.hasNextInt()) {
		    System.out.println("Please Enter a valid input");
		    scanner.next();
		}//scanner check
		int searchID = scanner.nextInt();
		scanner.nextLine();
		if (accountType==1) {
			sql = "SELECT * FROM employee WHERE id = ?";
		}else {
			sql = "SELECT * FROM client WHERE id = ?";
		}
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, searchID);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()==false) {
				System.out.println("There is no account with ID: " + searchID);
			}else {
				System.out.println("Enter First Name: ");
				String fn = scanner.nextLine();
				System.out.println("Enter Last Name: ");
				String ln = scanner.nextLine();
				if (accountType==1) {
					System.out.println("Enter Employment Type: ");
					type = scanner.nextLine();
					sql = "UPDATE employee SET first_name = ?, last_name = ?,employee_status = ? ,WHERE id = ?";
				}else {
					System.out.println("Enter Membership status: ");
					status = scanner.nextLine();
					System.out.println("Enter Membership type: ");
					type = scanner.nextLine();
					sql = "UPDATE employee SET first_name = ?, last_name = ?,member_type = ?,member_status = ? ,WHERE id = ?";
				}
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,fn);
					pst.setString(2,ln);
					if (accountType==1) {
						pst.setString(3, type);
						pst.setInt(4, searchID);
					}else {
						pst.setString(3, type);
						pst.setString(4, status);
						pst.setInt(5, searchID);
					}
					pst.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Error while updating data: " + e.getMessage());
				}	
			}
		} catch (SQLException e) {
			System.out.println("Error while retrieving data: " + e.getMessage());
		}
		
	}

	private void searchAccount(int accountType,Scanner scanner, Connection conn) {
		String sql;
		
		System.out.println("Enter ID: ");
		while (!scanner.hasNextInt()) {
		    System.out.println("Please Enter a valid input");
		    scanner.next();
		}//scanner check
		int searchID = scanner.nextInt();
		scanner.nextLine();
		if (accountType==1) {
			sql = "SELECT * FROM employee WHERE id = ?";
		}else {
			sql = "SELECT * FROM client WHERE id = ?";
		}
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, searchID);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String fn = rs.getString("first_name");
				String ln = rs.getString("last_name");
				if (accountType==1) {
					String type = rs.getString("employee_type");
					Employee acc = new Employee(id,fn,ln,type);
					System.out.println(acc);
				}else {
					String status = rs.getString("member_status");
					String type = rs.getString("member_type");
					Client acc = new Client(id,fn,ln,status,type);
					System.out.println(acc);
				}
			}else {
				System.out.println("There is no account with ID: " + searchID);
			}
		} catch (SQLException e) {
			System.out.println("Error while retrieving data: " + e.getMessage());
		}
	}

	private void AddAccount(int accountType,Scanner scanner, Connection conn) {
		String type;
		String status = null;
		String sql;
		System.out.println("Enter ID: ");
		while (!scanner.hasNextInt()) {
		    System.out.println("Please Enter a valid input");
		    scanner.next();
		}//scanner check
		int newInt = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter First Name: ");
		String fn = scanner.nextLine();
		System.out.println("Enter Last Name: ");
		String ln = scanner.nextLine();
		if (accountType==1) {
			System.out.println("Enter Employment Type: ");
			type = scanner.nextLine();
			sql = "INSERT INTO employee (id,first_name,last_name,employee_type) VALUES(?,?,?,?)";
		}else {
			System.out.println("Enter Membership status: ");
			status = scanner.nextLine();
			System.out.println("Enter Membership type: ");
			type = scanner.nextLine();
			sql = "INSERT INTO employee (id,first_name,last_name,member_status,member_type) VALUES(?,?,?,?)";
		}
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, newInt);
			pst.setString(2, fn);
			pst.setString(3, ln);
			if (accountType==1) {
				pst.setString(4,type);
			}else {
				pst.setString(4,status);
				pst.setString(5,type);
			}
			int count = pst.executeUpdate();
			System.out.println(count + "record(s) inserted");
		} catch (SQLException e) {
			System.out.println("Error adding info: " + e.getMessage());
		}
		
		
	}
}
