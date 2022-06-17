package vendingMachine.Payment;

public enum InputType {
	PinCode(4),
	ItemID(2);
	private final int length;
	InputType(int length){
		this.length=length;
	
	}
	public int getLength() {
		return length;
	}
}