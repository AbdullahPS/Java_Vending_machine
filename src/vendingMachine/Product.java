package vendingMachine;

import MockData.Item;

public class Product {
	private Item item;
	private int quantity;
	private String id;
	
	
	public Product(Item item,int quantity,String id){
		this.item=item;
		this.id=id;
		
		this.quantity=quantity;
		this.id=id;
	
	}
	public void decreaseQuantity(){
		this.quantity-=1;
	}
	
	
	public Item getItem() {
		return item;
	}
	
	public double getPrice() {
		return item.getPrice()
;	}
	
	public int getQuantity() {
		return quantity;}
	
	public boolean isAvailable() {
		return quantity>0;
	}
	public void setQuantity(int quantity) {
		this.quantity+=quantity;}
	
	
}
