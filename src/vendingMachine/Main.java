package vendingMachine;

import java.util.Scanner;

import User.User;
import payment.Card;
import payment.Coin;
import payment.Note;

public class Main {
	public static void main (String args[]) {


		VendingMachineImpl machine =new VendingMachineImpl();
		User user = new User("Abdullah",new Card("1234",0.5));
		//user.set
		boolean hasExited=false;

		while (!hasExited){
		Scanner scanner =new Scanner(System.in);
		System.out.println("Please Choose what do you want to do \n\n");
		System.out.println("1. look at items ");
		System.out.println("2. insert Card");
		System.out.println("3. put money");
		System.out.println("4. Select Items");
		System.out.println("5. Exit");

		try {
		int choice=scanner.nextInt();
	

		switch(choice) {
		case 1:
			user.showItems(machine.getSnackSlot().getItems());
			break;
		case 2:
			machine.getInput(scanner,user.getCard());
			break;
		case 3:
			do {
				int choice2=user.insertMoney(scanner);

				switch(choice2) {
				case 1:
					machine.acceptMoney(Coin.TenCent);
					break;
				case 2:
					machine.acceptMoney(Coin.TwentyCent);
					break;
				case 3:
					machine.acceptMoney(Coin.FiftyCent);
					break;
				case 4:
					machine.acceptMoney(Coin.OneDollar);
					break;
				case 5:
					machine.acceptMoney(Note.TwentyDollar);
					break;
				case 6:
					machine.acceptMoney(Note.FiftyDollar);
					break;
				case 7:
					machine.onCancelPress();
					break;
				default :
					System.out.println("Choose values aonly from 1 to 7");
					break;

				}
			}while (machine.getCanAcceptMoney());
			break;
		case 4:
			machine.getInput(scanner);
			break;
		case 5:
			hasExited=true;
			System.out.println("Thank you!! Enjoy your day");
			break;
		default :
			System.out.println("Choose values aonly from 1 to 5");
			break;
		}

		}
		catch(Exception e) {
			System.out.println("Choose values aonly from 1 to 5");
		}
		}
		}



		}

