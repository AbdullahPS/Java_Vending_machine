package vendingMachine;

public interface VendingMachine {
	void displayMessage(String message);
	boolean checkMoneyIsValid(int amount);
	void returnMoney();
	void returnProduct();
	
	

}
