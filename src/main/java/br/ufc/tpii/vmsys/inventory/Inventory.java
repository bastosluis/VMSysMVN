package br.ufc.tpii.vmsys.inventory;

import br.ufc.tpii.vmsys.inventory.exceptions.ItemAlreadyAdded;
import br.ufc.tpii.vmsys.inventory.exceptions.ItemNotFound;
import br.ufc.tpii.vmsys.inventory.exceptions.NullItemException;

public interface Inventory {

	public void addItem(Item item) throws ItemAlreadyAdded, NullItemException;

	public void removeItem(String itemName) throws ItemNotFound, NullItemException;

	public Item getItem(String itemName) throws ItemNotFound, NullItemException;

	public int numberOfItems();
}
