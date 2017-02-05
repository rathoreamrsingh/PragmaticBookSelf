package com.pragamtic.bookself.exception;

/**
 * 
 * @author amar
 * @version 1.0
 */
public class PragmaticBookSelfException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1809624367904141443L;

	/**
	 * Constructor to capture only message.
	 * 
	 * @param message
	 */
	public PragmaticBookSelfException(String message) {
		super(message);
	}

	/**
	 * Constructor to capture both message as well as throwable exception
	 */
	public PragmaticBookSelfException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor to capture only throwable exception
	 */
	public PragmaticBookSelfException(Throwable cause) {
		super(cause);
	}

}
