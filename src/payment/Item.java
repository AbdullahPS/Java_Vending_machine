package payment;

public enum Item {
	Mars(2),
	Snickers(2),
	Twix(2),
	KitKat(2),
	Oreo(1),
	Neo(1),
	Pringles(4),
	MnM(2.5),
	Doritos(2.4),
	Lay(2.3),
	Cheetos(3),
	Fritos(2),
	Nutella(5),	
	Bisley(0.5),
	Karnoosh(0.5),
	Hohos(1),
	DailyMilk(1),
	MilkaWhite(2),
	MilkaDark(3),
	Hanuta(4),
	AliBaba(0.4),
	Haribo(2),
	Toffifee(4),
	Corny(1),
	Bueno(1);
	private double price;
	Item(double price){
		this.price=price;
	
	}
	public double getPrice() {
		return price;
	}
}
