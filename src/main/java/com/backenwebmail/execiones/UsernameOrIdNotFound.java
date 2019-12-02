package com.backenwebmail.execiones;

public class UsernameOrIdNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6444474406356023914L;

	public UsernameOrIdNotFound () {
		super ("usuario o Id no encontrado");
	}
	
	public UsernameOrIdNotFound (String message) {
		super (message);
	}
	
	

}
