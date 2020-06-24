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
	private static final long serialVersionUID = 3656045561262849718L;

	public PlayerNotFoundException(Long id) {
		super("Could not find player " + id);
	}

}
