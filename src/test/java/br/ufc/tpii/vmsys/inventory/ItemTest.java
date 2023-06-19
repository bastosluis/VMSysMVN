package br.ufc.tpii.vmsys.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.tpii.vmsys.inventory.exceptions.DecrementCountZeroException;
import br.ufc.tpii.vmsys.inventory.exceptions.NullItemException;

class ItemTest {

	@Test
	void testItemCorrectName() {
		try {
			var item = new Item("coca", 10.0, 5);
			assertEquals("coca", item.getName());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testItemNullName() {
		Exception e = assertThrows(NullItemException.class, () -> {
			new Item(null, 10.0, 5);
		}); 

		String actualMessage = e.getMessage();
		String expectedMessage = "Tried adding an item with null name.";
		assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);

	}

	@Test
	void testGetName() {
		try {
			var item = new Item("coca", 10.0, 5);
			assertEquals("coca", item.getName());
		} catch (Exception e) {
			fail(e.getMessage());
			}	
		}

	@Test
	void testGetPrice() {
		try {
			var item = new Item("coca", 10.0, 5);
			assertEquals(10.0, item.getPrice());
		} catch (NullItemException e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testSetPrice() {
		try {
			var item = new Item("coca", 10.0, 5);
			item.setPrice(20.0);
			assertEquals(20.0, item.getPrice());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetCount() {
		try {
			var item = new Item("coca", 10.0, 5);
			assertEquals(5, item.getCount());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testDecCount() {
		try {
			var item = new Item("coca", 10.0, 5);
			item.decCount();
			assertEquals(4, item.getCount());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testDecCountNegative() {
		try {
			var item = new Item("coca", 10.0, 0);
			Exception e = assertThrows(DecrementCountZeroException.class, () -> {
				item.decCount();
			}); 

			String actualMessage = e.getMessage();
			String expectedMessage = "Tried to decrement item count 0.";
			assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testIncCount() {
		try {
			var item = new Item("coca", 10.0, 5);
			item.incCount();
			assertEquals(6, item.getCount());
		} catch (Exception e){
			fail(e.getMessage());
		}
	}
}
