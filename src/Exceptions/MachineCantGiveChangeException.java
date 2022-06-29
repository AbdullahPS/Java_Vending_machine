package Exceptions;

public class MachineCantGiveChangeException extends Exception{

	private static final long serialVersionUID = 9178379322569491902L;
	
	public MachineCantGiveChangeException(String errorMessage) {
        super(errorMessage);
    }

}
