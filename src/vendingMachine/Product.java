package vendingMachine;

import vendingMachine.Payment.Item;

public class Product {
	private Item item;
	private int quantity;
	private String id;
	
	
	public Product(Item item,int quantity,String id){
		this.item=item;
		
		this.quantity=quantity;
		this.id=id;
	
	}
	public Item getItem() {
		return item;
	}
	
	
	public int getQuantity() {
		return quantity;}
	
	public void setQuantity(int quantity) {
		this.quantity+=quantity;}
	
	public void decreaseQuantity(){
		this.quantity-=1;
	}
	
	public double getPrice() {
		return item.getPrice()
;	}
	public boolean isAvailable() {
		return quantity>0;
	}
	
	
}
