package Exceptions;

public class ItemOutOfStockException extends Exception{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 8547075416559177199L;

	/**
	 * 
	 */

	public ItemOutOfStockException(String errorMessage) {
	        super(errorMessage);
	    }

}
