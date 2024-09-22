package com.electioncommision.ivc.exceptionhandler;

public class EmailNotFound extends RuntimeException {
	private String message;

	public EmailNotFound(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
