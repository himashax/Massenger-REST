package com.Messenger.exception;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -96164161616L;
	
	public DataNotFoundException(String message) {
		super(message);
	}
	
}
