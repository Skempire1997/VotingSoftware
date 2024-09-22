package com.electioncommision.ivc.exceptionhandler;

public class PhoneNotFound extends RuntimeException {
	private String message;

	public PhoneNotFound(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
