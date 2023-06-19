package br.ufc.tpii.vmsys.inventory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.tpii.vmsys.inventory.exceptions.ItemAlreadyAdded;
import br.ufc.tpii.vmsys.inventory.exceptions.ItemNotFound;
import br.ufc.tpii.vmsys.inventory.exceptions.NullItemException;

//import br.ufc.tpii.vmsys.inventory.*;

class HashMapInventoryTest {

	@Test
	void testHashMapInventory() {
//		fail("Not yet implemented");
	}

	void testAddItemNull() {
		try {
			var hashInv = new HashMapInventory();
			Exception e = assertThrows(NullItemException.class, () -> {
				hashInv.addItem(null);
			});
			String actualMessage = e.getMessage();
			String expectedMessage = "Trying to add null item.";
			assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testAddItemCorrectly() {
		try {
			var item = new Item("coca", 10.0, 5);
			var hashInv = new HashMapInventory();
			hashInv.addItem(item);
			assertEquals(item, hashInv.getItem("coca"));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testAddItemAlreadyAdded() {
		try {
			var item = new Item("coca", 10.0, 5);
			var hashInv = new HashMapInventory();
			Exception e = assertThrows(ItemAlreadyAdded.class, () -> {
				hashInv.addItem(item);
				hashInv.addItem(item);
			});
			String actualMessage = e.getMessage();
			String expectedMessage = "Item already added: coca";
			assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testRemoveItemCorrectly() {
		try {
			var item =  new Item("coca", 10.0, 5);
			var hashInv = new HashMapInventory();
			hashInv.addItem(item);
			Exception e = assertThrows(ItemNotFound.class, () -> {
				hashInv.removeItem("coca");
				hashInv.removeItem("coca");
			});
			String actualMessage = e.getMessage();
			String expectedMessage = "Item not found: coca";
			assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testRemoveItemThatDoesntExist() {
		try {
			var hashInv = new HashMapInventory();
			Exception e = assertThrows(ItemNotFound.class, () -> {
				hashInv.removeItem("coca");
			});
			String actualMessage = e.getMessage();
			String expectedMessage = "Item not found: coca";
			assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testRemoveItemNull() {
		try {
			var hashInv = new HashMapInventory();
			Exception e = assertThrows(NullItemException.class, () -> {
				hashInv.removeItem(null);
			});
			String actualMessage = e.getMessage();
			String expectedMessage = "Trying to remove null item.";
			assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetItemCorrectly() {
		try {
			var item = new Item("coca", 10.0, 5);
			var hashInv = new HashMapInventory();
			hashInv.addItem(item);
			assertEquals(item, hashInv.getItem("coca"));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetItemThatDoesntExist() {
		try {
			var hashInv = new HashMapInventory();
			Exception e = assertThrows(ItemNotFound.class, () -> {
				hashInv.getItem("coca");
			});
			String actualMessage = e.getMessage();
			String expectedMessage = "Item not found: coca";
			assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testGetItemNull() {
		try {
			var hashInv = new HashMapInventory();
			Exception e = assertThrows(NullItemException.class, () -> {
				hashInv.getItem(null);
			});
			String actualMessage = e.getMessage();
			String expectedMessage = "Trying to get null item.";
			assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testNumberOfItems() {
		try {
			var item = new Item("coca", 10.0, 5);
			var hashInv = new HashMapInventory();
			hashInv.addItem(item);
			assertEquals(1, hashInv.numberOfItems());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
