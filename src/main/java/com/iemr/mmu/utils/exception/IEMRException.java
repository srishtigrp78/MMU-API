package com.iemr.mmu.utils.exception;

public class IEMRException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message = null;
	private Integer errorCode = null;

	public IEMRException(String message, Throwable cause) {
		super(message);
		this.message = message;
		super.setStackTrace(cause.getStackTrace());
	}

	public IEMRException(String message) {
		super(message);
		this.message = message;
	}
	
	public IEMRException(String message,Integer errorCode) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
	}
	public String toString() {
		return this.message;
	}

	public String getMessage() {
		return this.message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
}
