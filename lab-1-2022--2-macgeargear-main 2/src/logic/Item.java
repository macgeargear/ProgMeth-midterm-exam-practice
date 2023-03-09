package logic;

import exception.NameBlankException;

public class Item {

	private String itemName;
	private int price;

	// constructor
	public Item(String itemName) throws NameBlankException {
		this.setItemName(itemName);
		this.setPrice(0);
	}

	public Item(String itemName, int price) throws NameBlankException{
		//FILL CODE
		this.setItemName(itemName);
		this.setPrice(price);
	}

	// methods
	public boolean equals(Item other) {
		return (this.itemName.equals(other.getItemName()));
	}

	public String toString() {
		return this.itemName+" $"+this.price;
	}

	// getter & setter
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) throws NameBlankException {
		if (itemName.isBlank()) {
			throw new NameBlankException();
		} else {
			this.itemName = itemName;
		}
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		if (price < 0) price = 0;
		this.price = price;
	}

}
