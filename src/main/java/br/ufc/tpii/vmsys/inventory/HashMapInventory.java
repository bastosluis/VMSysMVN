package br.ufc.tpii.vmsys.inventory;

import java.util.HashMap;

import br.ufc.tpii.vmsys.inventory.exceptions.ItemAlreadyAdded;
import br.ufc.tpii.vmsys.inventory.exceptions.ItemNotFound;
import br.ufc.tpii.vmsys.inventory.exceptions.NullItemException;

public class HashMapInventory implements Inventory {

	private HashMap<String, Item> inventory;

	public HashMapInventory() {
		this.inventory = new HashMap<String, Item>();
	}

	public void addItem(Item item) throws ItemAlreadyAdded, NullItemException {
		if (item == null) {
			throw new NullItemException("Trying to add null item.");
		}
		
		if (this.inventory.containsKey(item.getName())) {
			throw new ItemAlreadyAdded("Item already added: " + item.getName());
		}

		this.inventory.put(item.getName(), item);
	}

	public void removeItem(String itemName) throws ItemNotFound, NullItemException {
		if (itemName == null) {
			throw new NullItemException("Trying to remove null item.");
		}
		if (!this.inventory.containsKey(itemName)) {
			throw new ItemNotFound("Item not found: " + itemName);
		}

		this.inventory.remove(itemName);
	}

	public Item getItem(String itemName) throws ItemNotFound, NullItemException {
		if (itemName == null) {
			throw new NullItemException("Trying to get null item.");
		}
		if (!this.inventory.containsKey(itemName)) {
			throw new ItemNotFound("Item not found: " + itemName);
		}

		return this.inventory.get(itemName);
	}

	public int numberOfItems() {
		return inventory.size();
	}
}