package vendingMachine.Payment;

 class Card implements Payment {
private int pinCode;
private double value;
private boolean validated=false;
//amount


Card(int pinCode,double value){
	this.pinCode=pinCode;
	this.value=value;
}

void dropAmount(double price){
	if(validated) {
		if(value>=price) {
			value-=price;

		}
	}
}

void validateCard(int pin){
	if(pin==pinCode) {
		validated=true;
	}
	
}
public double getValue() {
	return value;
}



}
