package Exceptions;

public class ItemNotSupportedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3469769252466354182L;

	public ItemNotSupportedException(String errorMessage) {
	        super(errorMessage);
	    }

}
