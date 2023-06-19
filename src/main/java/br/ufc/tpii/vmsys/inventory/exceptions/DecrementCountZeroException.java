package br.ufc.tpii.vmsys.inventory.exceptions;

public class DecrementCountZeroException extends Exception {

	private static final long serialVersionUID = 1L;

	public DecrementCountZeroException() {
		super();
	}

	public DecrementCountZeroException(String message) {
		super(message);
	}
}
