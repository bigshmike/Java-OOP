package edu.wccnet.mbrown99.pizzaApp.api;

public class CustomerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException (String msg) {
		super(msg);
	}
}
