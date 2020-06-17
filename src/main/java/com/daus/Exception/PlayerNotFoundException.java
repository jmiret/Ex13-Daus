package com.daus.Exception;

/**
 * 
 * @author jordi.miret
 *
 */

public class PlayerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6456379856928124597L;

	public PlayerNotFoundException(Long id) {
		super("Could not find player " + id);
	}

}
