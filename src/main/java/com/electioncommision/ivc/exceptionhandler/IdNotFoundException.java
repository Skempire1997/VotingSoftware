package com.electioncommision.ivc.exceptionhandler;

public class IdNotFoundException extends RuntimeException {
	private  String message;

	public IdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IdNotFoundException(String message) {
		this.message = message;
	}
	
	

}
