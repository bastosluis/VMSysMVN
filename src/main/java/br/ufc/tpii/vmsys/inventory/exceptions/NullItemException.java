package br.ufc.tpii.vmsys.inventory.exceptions;

public class NullItemException extends Exception {

	private static final long serialVersionUID = 1L;

	public NullItemException() {
		super();
	}

	public NullItemException(String message) {
		super(message);
	}
}
