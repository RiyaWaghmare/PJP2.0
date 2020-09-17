package com.sapient.service;

public class ProductException extends Exception{
	private static final long serialVersionUID = 1L;

	public ProductException() {
		super();
	}

	public ProductException(String message) {
			super(message);
	}

	public ProductException(String message,Throwable e) {
			super(message,e);
	}

}
