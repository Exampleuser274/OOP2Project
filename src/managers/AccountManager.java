package managers;
import java.sql.*;
import java.util.Scanner;
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
				AddAccount(accountType);
				break;
			case 2:
				searchAccount(accountType);
				break;
			case 3:
				updateAccount(accountType);
				break;
			case 4:
				removeAccount(accountType);
				break;
			case 5:
				accountLoop=false;
				break;
			default:
				System.out.println("Error. Enter 1 to 5");
			}//case
		}//menu Loop
	}
	private void removeAccount(int accountType) {
		// TODO Auto-generated method stub
		
	}

	private void updateAccount(int accountType) {
		// TODO Auto-generated method stub
		
	}

	private void searchAccount(int accountType) {
		// TODO Auto-generated method stub
		
	}

	private void AddAccount(int accountType) {
		// TODO Auto-generated method stub
		
	}
}
