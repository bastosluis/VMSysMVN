package br.ufc.tpii.vmsys.inventory;

import br.ufc.tpii.vmsys.inventory.exceptions.*;

public class Item {
	private String name;
	private double price = 0.0;
	private int count = 0;

	public Item(String name, double price, int count) throws NullItemException {
		if (name == null) {throw new NullItemException("Tried adding an item with null name.");}
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void decCount() throws DecrementCountZeroException {
		if (this.count == 0) { throw new DecrementCountZeroException("Tried to decrement item count 0."); }
		this.count--;
	}

	public void incCount() {
		this.count++;
	}
}