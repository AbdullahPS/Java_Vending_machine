package MockData;

import vendingMachine.Payment.Item;
import java.util.Random;


public class InitialProducts {
	public final static Item items[]= {
			Item.AliBaba,
            Item.Bisley,
            Item.Bueno,
            Item.Cheetos
            ,Item.Corny
            ,Item.DailyMilk
            ,Item.Doritos
            ,Item.Fritos
            ,Item.Hanuta
            ,Item.Haribo
            ,Item.Hohos
            ,Item.Karnoosh
            ,Item.KitKat
            ,Item.Lay
            ,Item.Mars
            ,Item.MilkaDark
            ,Item.MilkaWhite
            ,Item.MnM
            ,Item.Neo
            ,Item.Nutella
            ,Item.Oreo
            ,Item.Pringles
            ,Item.Snickers,
            Item.Toffifee,
            Item.Twix
            
};
	static Random rand = new Random();

	public final static int coins[]= {
			rand.nextInt(10-5) + 5,
			rand.nextInt(10-5) + 5,
			rand.nextInt(10-5) + 5,
			rand.nextInt(10-5) + 5,
			
	};
	public final static int notes[]= {
			rand.nextInt(10-5) + 5,
			rand.nextInt(10-5) + 5,
	
			
	};
	
	

}
