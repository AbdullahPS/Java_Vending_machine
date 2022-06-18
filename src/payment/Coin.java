package payment;

public enum Coin implements Payment {
	TenCent(0.10),
	TwentyCent(0.20),
	FiftyCent(0.50),
	OneDollar(1.0);
	private double value;
	Coin(double value){
		this.value=value;
		
	}
	public double getValue() {
		return value;
	}
}
