package logic;

import java.util.ArrayList;

public class Inventory {
	
	//fields
	private String playerName;
	private int money;
	private ArrayList<ItemCounter> items;

	// getter & setters
	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String name) {
		if (name.isBlank() || name.isEmpty()) {
			this.setPlayerName("Untitled Player");
			return;
		}
		this.playerName = name;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		if (money < 0) { 
			money = 0;
		}
		this.money = money;
	}

	public ArrayList<ItemCounter> getItems() {
		return this.items;
	}

	public void setItems(ArrayList<ItemCounter> items) {
		this.items = items;
	}
	
	//constructors
	public Inventory(String playerName) {
		this.setPlayerName(playerName);		
		this.setMoney(0);
		this.setItems(new ArrayList<ItemCounter>());
	}
	
	public Inventory(String playerName, int money) {
		this.setPlayerName(playerName);	
		this.setMoney(money);
		this.setItems(new ArrayList<ItemCounter>());
	}
	
	public Inventory(String playerName, int money, ArrayList<ItemCounter> items) {
		//FILL CODE
		this.setPlayerName(playerName);	
		this.setMoney(money);
		this.setItems(items);
	}
	
	//methods
	public String toString() {
		if (items.size() == 0) {
			return "EMPTY INVENTORY";
		}
		String out = "\n";
		for (int i=0; i<items.size(); i++) {
			out += i+1;
			out += ". ";
			out += items.get(i).toString();
			out += "\n";
		}
		return out;
	}
	public boolean existsInInventory(Item item) {
		//FILL CODE
		for (ItemCounter itemCount : items) {
			if (itemCount.getItem() == item && itemCount.getCount() >= 1 ) return true;
		}
		return false;
	}

	public void addItem(Item newItem, int count){
		//FILL CODE
		if (count < 0) return;
		for (ItemCounter itemCount : items) {
			if (itemCount.getItem() == newItem) {
				itemCount.setCount(itemCount.getCount() + count);
				return;
			}
		}
		items.add(new ItemCounter(newItem, count));
	}

	public void removeItem(Item toRemove, int count) {

		// if the amount is zero or negative, just return. nothing is removed.
		if (count <= 0)
			return;

		ItemCounter removeIfNeg = null;

		for (ItemCounter ic : items) {
			if (ic.getItem().equals(toRemove)) {
				// Remove the card equal to count.
				ic.setCount(ic.getCount() - count);
				removeIfNeg = ic;
			}
		}

		// If removeIfNeg isn't null (meaning something got removed) then we need to
		// check if it is negative.
		if (removeIfNeg != null) {
			// If it goes into the negative, then remove this entry from the deck entirely.
			// You cannot modify a for loop while it's inside, so this has to be done
			// outside.
			if (removeIfNeg.getCount() <= 0) {
				items.remove(removeIfNeg);
			}
		}

	}
	

	//FILL CODE
	
}
