package com.electioncommision.ivc.exceptionhandler;

public class DuplicateEntryException extends RuntimeException {
	private String message;

	public DuplicateEntryException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	

}
