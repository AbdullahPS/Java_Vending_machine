package vendingMachine;


import java.util.Scanner;

import Exceptions.CardIsBlockedException;
import Exceptions.ItemNotSupportedException;
import Exceptions.InsufficientBalanceException;
import Exceptions.ItemOutOfStockException;
import MockData.InitialProducts;
import components.Bucket;
import components.Display;
import components.Keypad;
import components.SnackSlot;
import payment.Card;
import payment.Coin;
import payment.InputType;
import payment.Item;
import payment.Note;

public class VendingMachineImpl implements VendingMachine {
	private Keypad keypad=new Keypad();
	private SnackSlot snackslot =new SnackSlot();
	private Bucket bucket =new Bucket();
	Display display =new Display(1);
	private boolean isCardInserted=false;
	private Scanner scanner =new Scanner(System.in);
	private boolean canAcceptMoney=false;
	private String selectedItemId=null;


	VendingMachineImpl(){
		initialize();
	}
	@Override
	  public void acceptMoney(Card card) {
		 keypad.pressKey(selectedItemId,InputType.PinCode);

	 }
	@Override
	  public void acceptMoney(Coin coin) {
		 if(!this.canAcceptMoney) {
			 display.displayMessage("Select an item first");
			 return;}
		bucket.insertCurrentCoin(coin);
		display.displayMessage(Double.toString(bucket.getCurrentAmount()));
		if(bucket.getCurrentAmount()>=snackslot.getName(selectedItemId).getPrice()) {
			makePayment(snackslot.getName(selectedItemId));
		}


	}
	@Override
	 public void acceptMoney(Note note) {
		   if(!this.canAcceptMoney) {
			   display.displayMessage("Select an item first");
				 return;}
			bucket.insertCurrentNote(note);
			display.displayMessage(Double.toString(bucket.getCurrentAmount()));
			if(bucket.getCurrentAmount()>=snackslot.getPrice(selectedItemId)) {
				makePayment(snackslot.getName(selectedItemId));
			}
	
	
	
		}
	


	 public boolean getCanAcceptMoney() {
		 return canAcceptMoney;
	 }
	 @Override
	 public void getInput(Scanner scanner) {
		display.displayMessage("Please enter the item ID");
		while(!keypad.getIsChecking()) {
			if(keypad.getValue().equals("cancel")) {
				onCancelPress();
				return;
			}

			String choice=scanner.nextLine();
			keypad.pressKey(choice,InputType.ItemID);
			display.displayMessage(keypad.getValue());
		}
		
		try {
			validateItemId(keypad.getValue());
		} catch (ItemOutOfStockException e) {
			display.displayMessage("Exception occured" +  e);
			keypad.setIsChecking(false);
			getInput(scanner);
		}
		catch(ItemNotSupportedException e)	{
			display.displayMessage("Exception occured" +  e);
			keypad.setIsChecking(false);
			getInput(scanner);
		
		}
	 }
	
   public void getInput(Scanner scanner,Card card)  {
	if(selectedItemId==null) {
		display.displayMessage("Please select an item first");
		return;
	}
	if(card.isBlocked) {
		display.displayMessage("You cant use this card please contact your bank");
		return;
	}
	isCardInserted=true;
	display.displayMessage("Please enter your Pin");
	while(!keypad.getIsChecking()) {
		if(keypad.getValue().equals("cancel")) {
			onCancelPress();
			return;
		}
		String choice=scanner.nextLine();
		keypad.pressKey(choice,InputType.PinCode);
		display.displayMessage(keypad.getValue());

	}
	try {
		validateCard(keypad.getValue(),card);
	} catch (CardIsBlockedException e) {
		display.displayMessage("Exception occured" +  e);
		 this.isCardInserted=false;
		 selectedItemId=null;
		 this.canAcceptMoney=false;
		 keypad.setIsChecking(false);
		
	} catch (InsufficientBalanceException e) {
		display.displayMessage("Exception occured" +  e);
		 this.isCardInserted=false;
		 selectedItemId=null;
		 this.canAcceptMoney=false;
		 keypad.setIsChecking(false);


	}
	keypad.clearValue();




}

	private void initialize() {
		  snackslot.initialize(InitialProducts.items);


		}
	private void makePayment(Item item) {
		 if(!isCardInserted) {
		double change=bucket.getCurrentAmount()-snackslot.getPrice(selectedItemId);
		change=Double.parseDouble(String.format("%.2f", change));
		bucket.insertPurchaseMoney();
		 display.displayMessage("You get back "+change);
		 bucket.getPossibleCombinations(change);}
		 else {
			 display.displayMessage("Card Payment completed succesfully");
			 this.isCardInserted=false;
		 }
		 vend(item);
		 keypad.setIsChecking(false);

	 }
	@Override
	public void onCancelPress() {
		  selectedItemId=null;
		  isCardInserted=false;
		  bucket.clearBucket();
		  keypad.clearValue();


	  }


	private void validateCard(String pin, Card card) throws CardIsBlockedException,InsufficientBalanceException{
		if(!card.isBlocked()) {
		card.validateCard(pin);
		if(card.isValidated()) {
			display.displayMessage("Succesfullty accepted Card");
			display.displayMessage("Checking for sufficient balance");
			if(card.getValue()>=snackslot.getName(selectedItemId).getPrice()) {
				card.withDrawMoney(snackslot.getName(selectedItemId).getPrice());
				makePayment(snackslot.getName(selectedItemId));
			}
			else {
				throw new InsufficientBalanceException("Not enough money in credit card");
				
			}

		}
		else {
			display.displayMessage("Wrong PinNumber try again");
			keypad.clearValue();
			System.out.println(card.isBlocked);
			System.out.println(card.wrongTries);
			keypad.setIsChecking(false);
			getInput(scanner,card);

		}


		}
		else {
			throw new CardIsBlockedException("You have entered your Pin too many times wrong. This Card cant long be used");
	}}
	private void validateItemId(String id)throws ItemOutOfStockException,ItemNotSupportedException{
		if(snackslot.sellsItem(id)) {
			if(snackslot.isAvailable(id)) {
				display.displayMessage(snackslot.getName(id).toString());
				display.displayMessage(snackslot.getPrice(id)+"$");
				//ask user for money
				keypad.clearValue();
				canAcceptMoney=true;
				selectedItemId=id;
				keypad.setIsChecking(false);

			}
			else {
				throw new ItemOutOfStockException("Item "+snackslot.getName(id)+" is out of stock");
			

			}
		}
		else {
			throw new ItemNotSupportedException("bro, we dont sell item "+id);

		

		}

	}
	private void vend(Item item) {
		display.displayMessage(item+ "is vending");
		 snackslot.decreaseQuantity(selectedItemId);
		 selectedItemId=null;
		 this.canAcceptMoney=false;
		 //clear selectedItemId, clear change, clear currentAmount, clear bucket
		 //getInput(scanner);

	 }
	public SnackSlot getSnackSlot() {
		return this.snackslot;
	}



}
