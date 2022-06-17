package User;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import vendingMachine.Product;
import vendingMachine.Payment.*;
public class User {
String name;
Card card;

public User(String name,Card card) {
	this.name = name;
	this.card = card;
}
public Card getCard() {
	return card;
}
public void insertCard( )  {
	
}
public int insertMoney(Scanner scanner) {
	System.out.println("Please Choose what do you want to insert \n\n");
	System.out.println("1. 10 Cent Coin ");
	System.out.println("2. 20 Cent Coin ");
	System.out.println("3. 50 Cent Coin ");
	System.out.println("4. 1 Dollar Coin ");
	System.out.println("5. 20 Dollar Coin ");
	System.out.println("6. 50 Dollar Coin ");
	return scanner.nextInt();
	
}
public void selectItems() {}
public void showItems(TreeMap<String,Product> machineItems){

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
	
}


}
