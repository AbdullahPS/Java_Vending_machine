package payment;

public enum Note implements Payment {
	
	TwentyDollar(20.0),
	FiftyDollar(50.0);
 
private double value;
Note(double value){
		this.value=value;
		
	}
public double getValue() {
		return value;
	}

}
