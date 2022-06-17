package vendingMachine.Payment;

public enum Note implements Payment {
	
	TwentyDollar(20.0),
	FiftyDollar(50.0);
	
 private final double value;
 
Note(double value){
		this.value=value;
		
	}
public double getValue() {
		return value;
	}

}
