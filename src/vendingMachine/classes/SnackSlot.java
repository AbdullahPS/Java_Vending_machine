
package vendingMachine.classes;

import java.util.TreeMap;

import vendingMachine.Product;
import vendingMachine.Payment.Item;

public class SnackSlot {
	
	private TreeMap<String,Product> items=new TreeMap<String,Product>();

	public SnackSlot() {
	}

	public void decreaseQuantity(String id) {
		this.items.get(id).decreaseQuantity();
	}
	
	public TreeMap<String, Product> getItems() {
		return items;
	}

	public Item getName(String id) {
		return items.get(id).getItem();
		
	}
	public double getPrice(String id) {
		return items.get(id).getPrice();
		
	}
	
	public int getQuantity(String id) {
		return this.items.get(id).getQuantity();
	}

	public void initialize(Item[] initItems) {
		if(items.isEmpty())
		for(int i=1;i<6;i++) {
			for(int j=0;j<5;j++) {
			
				String key=String.valueOf(i);
				switch(j) {
				case 0:
					key+='A';
				    break;
				case 1:
					key+='B';
				    break;
				case 2:
					key+='C';
				    break;
				case 3:
					key+='D';
				    break;
				case 4:
					key+='E';
				    break;

				}
				items.put(key, new Product(initItems[j+i],10,key));
				
			}
			
		}
	}
	public boolean isAvailable(String id) {
		return this.items.get(id).isAvailable();
	}
	public void refillItem(String id,int quantity) {
		this.items.get(id).setQuantity(quantity);
	}	public boolean sellsItem(String id) {
		return this.items.get(id)!=null;
	}

}
