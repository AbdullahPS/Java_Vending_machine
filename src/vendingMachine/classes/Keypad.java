package vendingMachine.classes;

import java.util.HashMap;

import vendingMachine.Payment.InputType;

public class Keypad {
private String value="";
private boolean isChecking=false;

final private  HashMap<String, String> keys = new HashMap<String, String>();
public Keypad(){
	initialize();

}
public void clearValue() {
	setValue("");
}

public boolean getIsChecking() {
	return isChecking;
}


public String getValue() {
	return value;
}
private void initialize() {
	if(keys.isEmpty()) {
	keys.put("1", "1");
	keys.put("2", "2");
	keys.put("3", "3");
	keys.put("4", "4");
	keys.put("5", "5");
	keys.put("6", "6");
	keys.put("7", "7");
	keys.put("8", "8");
	keys.put("9", "9");
	keys.put("0", "0");
	keys.put("A", "A");
	keys.put("B", "B");
	keys.put("C", "C");
	keys.put("D", "D");
	keys.put("E", "E");
	keys.put("clear", "clear");
	keys.put("delete", "delete");
	keys.put("cancel", "cancel");
	}
}

private boolean isValidLength(InputType type){
	int length=type.getLength();
	return value.length()==length;
}

public void pressKey(String input,InputType type) {
	int maximiumLength=type.getLength();

	if(keys.containsKey(input)) {
	if(input.equals("cancel"))setValue("cancel");
	if(value.length()==maximiumLength&&!input.equals("delete")&&!input.equals("clear"))
		return ;//dont allow user to press more then 2 or 4 values
	if(input.equals("clear"))
	{
		clearValue();	}
	else if (input.equals("delete")) {
		if (value.isEmpty())
			return ;
		else {
			setValue(value.substring(0,value.length()-1));
		}
	}
	
	else {//all numbers but OK
		if(value.length()>maximiumLength) return ;
		setValue(value+input);
	}
		if(isValidLength(type)) {
			setIsChecking(true);

		}
		
		
	}
	}

public void setIsChecking(boolean checking) {
	this.isChecking= checking;
}

private void setValue(String value) {
	this.value = value;
}
	}





