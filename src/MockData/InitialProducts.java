package MockData;

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

	public final static int MockCoins[]= {
			0,0,0,0

			
	};
	public final static int MockNotes[]= {
			rand.nextInt(100-50) + 50,
			rand.nextInt(100-50) + 50,

	
			
	};
	
	

}
