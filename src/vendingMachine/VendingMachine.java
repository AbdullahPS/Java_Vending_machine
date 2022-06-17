package vendingMachine;

public interface VendingMachine {
	boolean checkMoneyIsValid(int amount);
	void displayMessage(String message);
	void returnMoney();
	void returnProduct();
	
	

}
