package com.ronaldgarcia.workshopmongo.services.exception;

public class EmptyPostsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public EmptyPostsException(String msg) {
		super(msg);
	}
}
