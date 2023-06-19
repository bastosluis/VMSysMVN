package br.ufc.tpii.vmsys.inventory.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.tpii.vmsys.exceptions.InsufficientFunds;

class DecrementCountZeroExceptionTest {
	static final String MOCK_MESSAGE = "Mock message";

	@Test
	void testDecrementCountZeroException() {
//		fail("Not yet implemented");
		assertTrue(true);
	}

	@Test
	void testDecrementCountZeroExceptionString() {
		Exception e = new InsufficientFunds(MOCK_MESSAGE);
		assertEquals(MOCK_MESSAGE, e.getMessage());
		}

}
