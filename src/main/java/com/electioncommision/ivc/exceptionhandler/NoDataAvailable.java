package com.electioncommision.ivc.exceptionhandler;

public class NoDataAvailable extends RuntimeException {
	private String message;

	public NoDataAvailable(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
