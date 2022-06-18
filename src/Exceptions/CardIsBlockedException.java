package Exceptions;

public class CardIsBlockedException extends Exception  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 9061957308457898772L;

	public CardIsBlockedException(String errorMessage) {
	        super(errorMessage);
	    }
}
