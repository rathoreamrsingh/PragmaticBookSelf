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
public class PragmaticBookSelfResult<Result> {
	private Result result;
	private ResultCode resultCode;

	/**
	 * Constructor
	 * 
	 * @param result
	 */
	public PragmaticBookSelfResult(Result result) {
		this.result = result;
	}

	public PragmaticBookSelfResult(Result result, ResultCode resultCode) {
		this.result = result;
		this.resultCode = resultCode;
	}

	public PragmaticBookSelfResult() {
	}

	public void setRestltedObject(Result result) {
		this.result = result;
	}

	public Result getResultedObject() {
		return this.result;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public ResultCode getResultCode() {
		return this.resultCode;
	}
}
