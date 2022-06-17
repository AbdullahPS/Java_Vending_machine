package vendingMachine;


import java.util.Scanner;

import MockData.*;
import vendingMachine.Payment.Coin;
import vendingMachine.Payment.Item;
import vendingMachine.Payment.Note;
import vendingMachine.classes.Bucket;
import vendingMachine.classes.Keypad;
import vendingMachine.classes.SnackSlot;

public class VendingMachineImpl implements VendingMachine {
	Keypad keypad=new Keypad();
	private SnackSlot snackslot =new SnackSlot();
	private Bucket bucket =new Bucket();
	
	Scanner scanner =new Scanner(System.in);
	private boolean canAcceptMoney=false;
	public boolean willVend=false;
	private String selectedItemId=null;

	VendingMachineImpl(){
		initialize();
	}
	  private void initialize() {
		  snackslot.initialize(InitialProducts.items);
		
		
		}
	
	 
	 private void vend(Item item) {
		 displayMessage(item+ "is vending");
		 snackslot.decreaseQuantity(selectedItemId);
		 double change=bucket.getCurrentAmount()-snackslot.getPrice(selectedItemId);
		 bucket.insertPurchaseMoney();
		 displayMessage("You get back "+change);
		 bucket.getPossibleCombinations(change);;
		 selectedItemId=null;
		 //getInput(scanner);
		 
	 }
	 	

	 public void insertMoney(Coin coin) {
		 if(!this.canAcceptMoney) {
			 displayMessage("Select an item first");
			 return;}
		bucket.insertCurrentCoin(coin);
		displayMessage(Double.toString(bucket.getCurrentAmount()));
		if(bucket.getCurrentAmount()>=snackslot.getPrice(selectedItemId)) {
			vend(snackslot.getName(selectedItemId));
		}
			
			

		
		
		
	}
   public void insertMoney(Note note) {
	   if(!this.canAcceptMoney) {
			 displayMessage("Select an item first");
			 return;}
		bucket.insertCurrentNote(note);
		displayMessage(Double.toString(bucket.getCurrentAmount()));
		if(bucket.getCurrentAmount()>=snackslot.getPrice(selectedItemId)) {
			vend(snackslot.getName(selectedItemId));
		}
			
			
		
	}
	public void displayMessage(String message) {

		System.out.println(message);
	}
	public void getInput(Scanner scanner) {
		while(!keypad.getIsChecking()) {
			String choice=scanner.nextLine();
			keypad.pressKey(choice);
			displayMessage(keypad.getValue());
		}
		String id=keypad.getValue();

		if(snackslot.sellsItem(keypad.getValue())) {
			if(snackslot.isAvailable(keypad.getValue())) {
				displayMessage(snackslot.getName(id).toString());
				displayMessage(snackslot.getPrice(id)+"$");
				//ask user for money
				canAcceptMoney=true;
				selectedItemId=id;
					
					
				
			
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
