package br.ufc.tpii.vmsys;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.ufc.tpii.vmsys.exceptions.*;
import br.ufc.tpii.vmsys.inventory.*;
import br.ufc.tpii.vmsys.inventory.exceptions.NullItemException;

class VendingMachineTest {

//	@Test
//	void testVendingMachine() {
//		fail("Not yet implemented");
//	}

	@Test
	void testAddZeroCoins() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		try { 
			vm.addCoins(0);
		} catch (NegativeFundsException nfe) {
			fail(nfe.getMessage());
		}
		assertEquals(0, vm.howManyCoinsLeft());
	}
	
	@Test
	void testAddPositiveCoins() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		try { 
			vm.addCoins(10);
		} catch (NegativeFundsException nfe) {
			fail(nfe.getMessage());
		}
		assertEquals(10, vm.howManyCoinsLeft());
	}
	
	@Test
	void testAddNegativeCoins() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		Exception e = assertThrows(NegativeFundsException.class, () -> {
			vm.addCoins(-10);
		});
		String actualMessage = e.getMessage();
		String expectedMessage = "Tried adding -10.0 coins";
		assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
	}
	
	@Test
	void testAddNoCoins() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		assertEquals(0, vm.howManyCoinsLeft());
	}
	@Test
	void testWithdrawZeroCoins() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		vm.withdrawRemainingCoins();
		assertEquals(0, vm.howManyCoinsLeft());
	}

	@Test
	void testWithdrawRemainingCoinsReturn() {
		VendingMachine vm = new VendingMachine(new HashMapInventory());
		try { 
			vm.addCoins(100);
		} catch (NegativeFundsException nfe) {
			fail(nfe.getMessage());
		}
		double withdrawnCoins = vm.withdrawRemainingCoins();
		assertEquals(withdrawnCoins, 100);
	}
	
	@Test
	void testWithdrawRemainingCoinsDoesItLeaveZero() {
		var vm = new VendingMachine(new HashMapInventory());
		try { 
			vm.addCoins(100);
		} catch (NegativeFundsException nfe) {
			fail(nfe.getMessage());
		}
		vm.withdrawRemainingCoins();
		assertEquals(0, vm.howManyCoinsLeft());
	}
	
	@Test
	void testHowManyCoinsLeftDoesItShowZero() {
		var vm = new VendingMachine(new HashMapInventory());
		assertEquals(0, vm.howManyCoinsLeft());
	}	
	
	@Test
	void testHowManyCoinsLeftDoesItShowCorrectly() {
		var vm = new VendingMachine(new HashMapInventory());
		try {
			vm.addCoins(100);
		} catch (NegativeFundsException nfe) {
			fail(nfe.getMessage());
		}
		assertEquals(100, vm.howManyCoinsLeft());
	}

	@Test
	void testVendCorrectItemBalance() {
		try {			
			var inv = new HashMapInventory();
			var item = new Item("coca", 10.0, 5);
			inv.addItem(item);
			var vm = new VendingMachine(inv);
			vm.addCoins(100);
			vm.vend("coca");
			assertEquals(90.0, vm.howManyCoinsLeft());
		} catch (Exception e) {
			fail(e.getMessage());			
		}
	}
	
	
//	@Test
//	void testVendCorrectItemQuantity() {
//		var inv = new HashMapInventory();
//		var item = new Item("coca", 10.0, 5);
//		try {			
//			inv.addItem(item);
//			var vm = new VendingMachine(inv);
//			vm.addCoins(100);
//			for (int i=0; i<5; i++) {
//				vm.vend("coca");
//			}
//			assertEquals(vm.getInventory.getItem("coca"));
//		} catch (Exception e) {
//			fail(e.getMessage());			
//		} 
//	}

	@Test
	void testVendOutOfStock() {
		try {
			var inv = new HashMapInventory();
			var item = new Item("coca", 10.0, 5);
		Exception e = assertThrows(OutOfStock.class, () -> {
				inv.addItem(item);
				var vm = new VendingMachine(inv);
				vm.addCoins(100);
				for (int i=0; i<100; i++) {
					vm.vend("coca");
				}
			});
		String actualMessage = e.getMessage();
		String expectedMessage = "Item out of stock: coca";
		assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
	
		} catch (NullItemException e) {
		fail(e.getMessage());
		}
	}
	
	
	@Test
	void testVendInvalidSelection() {
		try {
		var inv = new HashMapInventory();
		var item = new Item("coca", 10.0, 5);
		Exception e = assertThrows(InvalidSelection.class, () -> {
				inv.addItem(item);
				var vm = new VendingMachine(inv);
				vm.addCoins(100);
				vm.vend("coca1");
			});
		String actualMessage = e.getMessage();
		String expectedMessage = "Invalid item selection: coca1";
		assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		
		} catch (NullItemException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testVendNullSelection() {
		try {
		var inv = new HashMapInventory();
		var item = new Item("coca", 10.0, 5);
		Exception e = assertThrows(NullItemException.class, () -> {
				inv.addItem(item);
				var vm = new VendingMachine(inv);
				vm.addCoins(100);
				vm.vend(null);
			});
		String actualMessage = e.getMessage();
		String expectedMessage = "Trying to get null item.";
		assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		
		} catch (NullItemException e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testVendInsufficientFunds() {
		try {
		var inv = new HashMapInventory();
		var item = new Item("coca", 10.0, 5);
		Exception e = assertThrows(InsufficientFunds.class, () -> {
				inv.addItem(item);
				var vm = new VendingMachine(inv);
				vm.vend("coca");
			});
		String actualMessage = e.getMessage();
		String expectedMessage = "Insufficient coins to buy coca: 0.0";
		assertTrue(actualMessage.contains(expectedMessage), "Expected Message: "+expectedMessage+ "\nActual Message: "+actualMessage);
		} catch (NullItemException e){
			fail(e.getMessage());
		}
	}
}
