package com.backenwebmail.execiones;

public class NotalecturaOrIdFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8322365691323386560L;

	
	public NotalecturaOrIdFound () {
		super ("Id no encontrado");
	}
	
	public NotalecturaOrIdFound (String message) {
		super (message);
	}
	
	
}
