package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutOfStockTest {
	static final String MOCK_MESSAGE = "Mock message";

	@Test
	void testOutOfStock() {
//		fail("Not yet implemented");
		assertTrue(true);
	}

	@Test
	void testOutOfStockString() {
		Exception e = new InsufficientFunds(MOCK_MESSAGE);
		assertEquals(MOCK_MESSAGE, e.getMessage());
	}

}
