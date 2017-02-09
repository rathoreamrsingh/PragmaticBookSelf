/**
 * 
 * Copyright *
 *
 */
package com.pragamtic.bookself.result;

/**
 * @author amar
 *
 * @version 1.0
 */
public class ResultCode {
	private ResultCodes code = ResultCodes.SUCCESSFUL;

	public enum ResultCodes {
		SUCCESSFUL, FAILURE
	}

	/**
	 * 
	 */
	public ResultCode(ResultCodes code) {
		this.code = code;
	}

	/**
	 * 
	 */
	public ResultCode() {

	}

	/**
	 * Setter method for result code.
	 * 
	 * @param codes
	 */
	public void setResultcode(ResultCodes codes) {
		this.code = code;
	}

	/**
	 * Getter for getting the result code
	 * 
	 * @return
	 */
	public ResultCodes getResultCode() {
		return this.code;
	}
}
