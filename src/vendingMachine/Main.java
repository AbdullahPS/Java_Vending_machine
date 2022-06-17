package vendingMachine;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


import vendingMachine.Payment.Coin;
import vendingMachine.Payment.Item;
import vendingMachine.Payment.Note;

public class Main {
	public static void main (String args[]) {
	
	
		VendingMachineImpl machine =new VendingMachineImpl();
		TreeMap<String,Product> machineItems =machine.getSnackSlot().getItems();
		int i=0;

		for (Map.Entry<String, Product> entry : machineItems.entrySet()) {
			i++;
			System.out.print(entry.getKey()+"\t" );
			Item product=entry.getValue().getItem();
			System.out.print(product.name());
			for(int k=0;k<12-product.name().length();k++) {
				System.out.print(" ");
				
			}
			System.out.print(product.getPrice()+"$  ||   ");
			if(i%3==0) {
				System.out.println("\n--------------------------------------------------------------------------------");
	}
			}
		
		System.out.println("Please Choose your snack\n\n");

		Scanner scanner =new Scanner(System.in);

		machine.getInput(scanner);
		System.out.println("Please Choose what do you want to insert \n\n");
		System.out.println("1. 10 Cent Coin ");
		System.out.println("2. 20 Cent Coin ");
		System.out.println("3. 50 Cent Coin ");
		System.out.println("4. 1 Dollar Coin ");
		System.out.println("5. 20 Dollar Coin ");
		System.out.println("6. 50 Dollar Coin ");
		System.out.println("7. Bank Card");
		System.out.println("8. I go away ");
		while (true) {
		if(machine.willVend)break;
		int choice=scanner.nextInt();

		switch(choice) {
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
		case 8:
		
		}
		}

		

			
		}

		
		
	}
