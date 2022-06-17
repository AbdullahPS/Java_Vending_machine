package vendingMachine;


import java.util.Scanner;

import MockData.*;
import vendingMachine.Payment.*;
import vendingMachine.classes.Bucket;
import vendingMachine.classes.Keypad;
import vendingMachine.classes.SnackSlot;

public class VendingMachineImpl implements VendingMachine {
	Keypad keypad=new Keypad();
	private SnackSlot snackslot =new SnackSlot();
	private Bucket bucket =new Bucket();
	private boolean isCardInserted=false;
	
	Scanner scanner =new Scanner(System.in);
	private boolean canAcceptMoney=false;
	private String selectedItemId=null;
	
	
	VendingMachineImpl(){
		initialize();
	}
	  private void initialize() {
		  snackslot.initialize(InitialProducts.items);
		
		
		}
	
	 public boolean getCanAcceptMoney() {
		 return canAcceptMoney;
	 }
	 private void vend(Item item) {
		 displayMessage(item+ "is vending");
		 snackslot.decreaseQuantity(selectedItemId);
		 selectedItemId=null;
		 this.canAcceptMoney=false;
		 //clear selectedItemId, clear change, clear currentAmount, clear bucket 
		 //getInput(scanner);
		 
	 }
	 private void makePayment(Item item) {
		 if(!isCardInserted) {
		double change=bucket.getCurrentAmount()-snackslot.getPrice(selectedItemId);
		 bucket.insertPurchaseMoney();
		 displayMessage("You get back "+change);
		 bucket.getPossibleCombinations(change);}
		 else {
			 this.isCardInserted=false;
		 }
		 vend(item);
		 keypad.setIsChecking(false);
		 
	 }


	 
	 public void acceptMoney(Card card) {
		 keypad.pressKey(selectedItemId,InputType.PinCode);
		 
	 }

	 public void acceptMoney(Coin coin) {
		 if(!this.canAcceptMoney) {
			 displayMessage("Select an item first");
			 return;}
		 if(isCardInserted) {
			 displayMessage("You are currently inside a bank session, cancel it first");
		 	}
		bucket.insertCurrentCoin(coin);
		displayMessage(Double.toString(bucket.getCurrentAmount()));
		if(bucket.getCurrentAmount()>=snackslot.getName(selectedItemId).getPrice()) {
			makePayment(snackslot.getName(selectedItemId));
		}
			
		
	}
   public void acceptMoney(Note note) {
	   if(!this.canAcceptMoney) {
			 displayMessage("Select an item first");
			 return;}
		bucket.insertCurrentNote(note);
		displayMessage(Double.toString(bucket.getCurrentAmount()));
		if(bucket.getCurrentAmount()>=snackslot.getPrice(selectedItemId)) {
			makePayment(snackslot.getName(selectedItemId));
		}
			
			
		
	}
	public void displayMessage(String message) {
		System.out.println(message);
	}
	
	public void getInput(Scanner scanner,Card card) {
		if(selectedItemId==null) {
			System.out.println("Please select an item first");
			return;
		}
		isCardInserted=true;
		System.out.println("Please enter your Pin");
		while(!keypad.getIsChecking()) {
			String choice=scanner.nextLine();
			keypad.pressKey(choice,InputType.PinCode);
			displayMessage(keypad.getValue());

		}
		validateCard(keypad.getValue(),card);
		keypad.clearValue();




	}
	
	public void getInput(Scanner scanner) {
		displayMessage("Please enter the item ID");
		while(!keypad.getIsChecking()) {
			String choice=scanner.nextLine();
			keypad.pressKey(choice,InputType.ItemID);
			displayMessage(keypad.getValue());
		}
		validateItemId(keypad.getValue());

	}
	private void validateItemId(String id) {
		if(snackslot.sellsItem(id)) {
			if(snackslot.isAvailable(id)) {
				displayMessage(snackslot.getName(id).toString());
				displayMessage(snackslot.getPrice(id)+"$");
				//ask user for money
				keypad.clearValue();
				canAcceptMoney=true;
				selectedItemId=id;
				keypad.setIsChecking(false);
					
			}
			else {
				displayMessage("Item "+id+" is out of stock");
				keypad.setIsChecking(false);
				getInput(scanner);

			}
		}
		else {//machine does not sell item throw exception
			System.out.println("bro, we dont sell item "+id);
			keypad.setIsChecking(false);
			getInput(scanner);

		}
		
	}
	private void validateCard(String pin, Card card) {
		if(!card.isBlocked()) {
		card.validateCard(pin);
		if(card.isValidated()) {
			System.out.println("Yes correct broooh");
			System.out.println("Let's see if you have money");
			if(card.getValue()>=snackslot.getName(selectedItemId).getPrice()) {
				System.out.println("seems youre rich");
				makePayment(snackslot.getName(selectedItemId));
			}
			else {
				System.out.println("ohh youre puur");

			}
			
		}
		else {
			System.out.println("Nope Wrong tryyy again");
			keypad.clearValue();
			System.out.println(card.isBlocked);
			System.out.println(card.wrongTries);
			keypad.setIsChecking(false);
			getInput(scanner,card);
			//getInput( scanner,card);

		}


		}
		//TODO:Throw exception
		else {System.out.println("So happy youre blocked now ?");}
	}
public boolean checkMoneyIsValid(int amount) {
		return true;
		
	}
	public void returnMoney() {
		
	};
	public SnackSlot getSnackSlot() {
		return this.snackslot;
	}
	public void returnProduct() {
		
	};
	
	
}
