package Exceptions;

public class InsufficientBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4458269361417530701L;
	public InsufficientBalanceException(String errorMessage) {
        super(errorMessage);
    }
}
