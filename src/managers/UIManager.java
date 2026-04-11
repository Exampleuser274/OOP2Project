package managers;

import java.util.Scanner;


public class UIManager {
	
	public UIManager() {
		boolean main = true;
		Scanner scanner = new Scanner(System.in);
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
			switch(mainInt) {
			case 1:
				new AccountManager(scanner);
				break;
			case 2:
				new EquipmentManager(scanner);
				break;
			case 3:
				System.out.println("Goodbye");
				//ConnectionManager.disconnect();
				scanner.close();
				main = false;
				break;
			default:
				System.out.println("Error. Enter 1 to 3");
			}//switch
			
		}//main loop
	}//constructor
}
