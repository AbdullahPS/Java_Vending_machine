package vendingMachine.classes;

import java.util.HashMap;

public class Keypad {
private String value="";
private boolean isChecking=false;

public boolean getIsChecking() {
	return isChecking;
}
public void setIsChecking(boolean checking) {
	this.isChecking= checking;
}
private boolean isValidLength(){
	return value.length()==2;
}

final private  HashMap<String, String> keys = new HashMap<String, String>();


private void initialize() {
	if(keys.isEmpty()) {
	keys.put("1", "1");
	keys.put("2", "2");
	keys.put("3", "3");
	keys.put("4", "4");
	keys.put("5", "5");
	keys.put("A", "A");
	keys.put("B", "B");
	keys.put("C", "C");
	keys.put("D", "D");
	keys.put("E", "E");
	keys.put("clear", "clear");
	keys.put("delete", "delete");
	}
}
public Keypad(){
	initialize();

}

public String getValue() {
	return value;
}

public void clearValue() {
	setValue("");
}

private void setValue(String value) {
	this.value = value;
}
public void pressKey(String input) {
	
	if(keys.containsKey(input)) {
	if(value.length()==2&&!input.equals("delete")&&!input.equals("Ok")&&!input.equals("clear"))
		return ;//dont allow user to press more then 2 values
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
	
	else if(!input.equals("Ok")){//all numbers but OK
		if(value.length()>2) return ;
		setValue(value+input);
	}
		if(isValidLength()) {
			setIsChecking(true);

		}
		
		
	}
	}
	}





