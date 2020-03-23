package backend;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		displayMainMenu();
		String input;
		Scanner scan = new Scanner(System.in);
		input = scan.next();
		switch(input) {
		case "A":
			clientMenu();
			break;
		case "B":
			vehicleOwnerMenu();
			break;
		case "C":
			VCMMenu();
		case "D":
			break;
		}
		
		
	}
	
	public static void displayMainMenu() {
		System.out.println("A = Client\n" + 
				"B = Vehicle Owner\n" + 
				"C = Vehicular Cloud Manager\n" + 
				"D = Exit");
	}
	
	public static void clientMenu() {
		
	}
	
	public static void vehicleOwnerMenu() {
		System.out.println("Hello");
	}
	
	public static void VCMMenu() {
		
	}

}
