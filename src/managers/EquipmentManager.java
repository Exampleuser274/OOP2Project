package managers;

import java.util.Scanner;

public class EquipmentManager {
	public EquipmentManager(Scanner scanner) {
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
			switch(equipmentInt) {
			case 1:
				AddEquipment();
				break;
			case 2:
				searchEquipment();
				break;
			case 3:
				updateEquipment();
				break;
			case 4:
				removeEquipment();
				break;
			case 5:
				equipLoop=false;
				break;
			default:
				System.out.println("Error. Enter 1 to 5");
			}//case
		}//menu Loop
	}//Constructor

	private void removeEquipment() {
		// TODO Auto-generated method stub
		
	}

	private void updateEquipment() {
		// TODO Auto-generated method stub
		
	}

	private void searchEquipment() {
		// TODO Auto-generated method stub
		
	}

	private void AddEquipment() {
		// TODO Auto-generated method stub
		
	}
}//Class
