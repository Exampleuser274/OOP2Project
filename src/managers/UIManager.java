package managers;

import java.sql.*;
import java.util.Scanner;


public class UIManager {
	public UIManager() {
		// TODO Auto-generated constructor stub
	}

	public void Menu(Scanner scanner, Connection conn,EquipmentManager equip,AccountManager account) {
		boolean main = true;
		int mainInt;
		while (main) {
			System.out.println("Welcome to the gym manager system");
			System.out.println("Please select a choice:");
			System.out.println("1. Account managment");
			System.out.println("2. Inventory anagment");
			System.out.println("3. quit");
			while (!scanner.hasNextInt()) {
			    System.out.println("Please Enter a valid input");
			    scanner.next();
			}//scanner check
			mainInt = scanner.nextInt();
			scanner.nextLine();
			switch(mainInt) {
			case 1:
				account.menu(scanner, conn);
				break;
			case 2:
				equip.menu(scanner, conn);
				break;
			case 3:
				System.out.println("Goodbye");
				main = false;
				break;
			default:
				System.out.println("Error. Enter 1 to 3");
			}//switch
			
		}//main loop
	}
}
