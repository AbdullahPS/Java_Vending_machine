package vendingMachine.Payment;

public class Card implements Payment {
private String pinCode;
private double value;
private boolean validated=false;
public int wrongTries=0;
public boolean isBlocked = false;
//amount


public Card(String pinCode,double value){
	this.pinCode=pinCode;
	this.value=value;
}

void dropAmount(double price){
	if(validated) {
		if(value>=price) {
			value-=price;

		}
	}
	//throw error not valdiated
}

public void validateCard(String pin){
	if(!isBlocked) {
	if(pinCode.equals(pin)) {
		setValidated();
	}
	else {wrongTries++;}
	if(wrongTries==3) {
		isBlocked=true;
	}
	}
	//throw exception
	
}
public boolean isBlocked() {
	return isBlocked;
}

public boolean isValidated() {
	return validated;
}

private void setValidated() {
	this.validated = true;
}

public double getValue() {
	return value;
	//exception
}



}
