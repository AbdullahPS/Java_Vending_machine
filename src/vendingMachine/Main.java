package vendingMachine;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


import vendingMachine.Payment.Coin;
import vendingMachine.Payment.Item;
import vendingMachine.Payment.Note;
import User.User;

public class Main {
	public static void main (String args[]) {
	
		
		VendingMachineImpl machine =new VendingMachineImpl();
		User user = new User();
		boolean hasExited=false;

		while (!hasExited){
		System.out.println("Please choose the action the user wants to perform");
		Scanner scanner =new Scanner(System.in);
		System.out.println("Please Choose what do you want to do \n\n");
		System.out.println("1. look at items ");
		System.out.println("2. look at display");
		System.out.println("3. money");
		System.out.println("4. Sect Items");
		System.out.println("5.Bye");

		int choice=scanner.nextInt();

		switch(choice) {
		case 1:
			user.showatItems(machine.getSnackSlot().getItems());
			break;
		case 2:
			break;
		case 3:
			while (machine.getCanAcceptMoney()&&!hasExited) {
				int choice2=user.insertMoney(scanner);

				switch(choice2) {
				case 1:
					machine.insertMoney(Coin.TenCent);
					break;
				case 2:
					machine.insertMoney(Coin.TwentyCent);
					break;
				case 3:
					machine.insertMoney(Coin.FiftyCent);
					break;
				case 4:
					machine.insertMoney(Coin.OneDollar);
					break;
				case 5:
					machine.insertMoney(Note.TwentyDollar);
					break;
				case 6:
					machine.insertMoney(Note.FiftyDollar);
				break;
					
				}
				
			}
			break;
		case 4:
			machine.getInput(scanner);
			break;
		case 5:
			hasExited=true;
			System.out.println("Thank you!! Enjoy your day");
			break;
		}
	
		


		}
		}


			
		}

		
		
	
