package logic;

import java.util.ArrayList;

public class Market {

	// fields
	ArrayList<Item> allItems;

	// constructors
	public Market() {
		this.setAllItems(new ArrayList<Item>());
	}

	public Market(ArrayList<Item> items) {
		this.setAllItems(new ArrayList<Item>());
		this.addAllItems(items);

	}

	// methods
	public String toString() {
		String out = "\n";
		for (int i = 0; i < allItems.size(); i++) {
			out += i + 1;
			out += ". ";
			out += allItems.get(i).toString();
			out += "\n";
		}
		return out;
	}

	public void addAllItems(ArrayList<Item> items) {
		//FILL CODE
		if (items == null) return;
		for (Item item : items) {
			boolean isHave = false;
			for (Item existItem : this.allItems) {
				if (existItem.equals(item)) {
					isHave = true;
				}
			}
			if (!isHave) {
				this.allItems.add(item);
				System.out.println(item + " Added to the market");
			} else {
				System.out.println(item + " is duplicated, Item will not be added.");
			}
		}		
	}

	//getter setters 
	public ArrayList<Item> getAllItems() {
		return this.allItems;
	}

	public void setAllItems(ArrayList<Item> items) {
		this.allItems = items;
	}
	//FILL CODE


}
