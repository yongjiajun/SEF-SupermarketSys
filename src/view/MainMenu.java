package view;

import java.util.Scanner;

public class MainMenu {

	// serves as view (for now), NOT WORKING YET
	
	//TODO make login work
	
	public MainMenu() {
		mainMenu();
	}
	
	private void mainMenu()
	{
		System.out.println("Welcome to XD Supermarket Support System");
		System.out.println("\nPlease select one of the following:");
		System.out.println("1 - Continue as Customer");
		System.out.println("2 - Continue as Staff"); // admin
		System.out.println("3 - Log off\n"); // shown to staffs not customers
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		if (input == 1)
		{
			
		}
		else if (input == 2)
		{
			System.out.println("Login as:");
			System.out.println("1 - Sales staff");
			System.out.println("2 - Warehouse staff");
			System.out.println("3 - Manager\n");
			
			input = scan.nextInt();
			if (input == 1)
			{
				
			}
			else if (input == 2)
			{
				
			}
			else if (input == 3)
			{
				
			}
			else {
				printInvalidInput();
				mainMenu();
			}
		}
		else if (input == 3)
		{
			System.out.println("Thanks for using XD Supermarket Support System!");
			System.exit(0);
		}
		else {
			printInvalidInput();
			mainMenu();
		}
	}
	
	private static void printInvalidInput() {
		System.out.println("Invalid input. Please try again.");
	}
}
