package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import exception.NameBlankException;

public class ItemUtil {

	public static Scanner sc = new Scanner(System.in);

	public static boolean itemNameIsExist(Market market, String itemName) {
		for (Item item : market.getAllItems()) {
			if (item.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasEnoughMoneytoBuy(Inventory toBuy, Item item, int amount) {
		return (toBuy.getMoney() >= item.getPrice() * amount);
	}

	public static ArrayList<Item> getItemFromFile(String filename) throws NumberFormatException {
		ArrayList<Item> itemsFromFile = new ArrayList<Item>();
		File fileToRead = new File(filename);

		try (Scanner sc = new Scanner(fileToRead)) {
			while (sc.hasNextLine()) {
				String[] currItem = sc.nextLine().split(" ");
				try {
					Boolean found = false;
					String name = currItem[0];
					int amount = Integer.valueOf(currItem[1]);
					Item newItem = new Item(name, amount);
					for (Item i : itemsFromFile) {
						if (i.equals(newItem)) {
							found = true;
						}
					}
					if (!found) {
						itemsFromFile.add(newItem);
					} else {
						System.out.println(newItem.getItemName() + " is duplicated, Item will not be added.");
					}
				} catch (NumberFormatException | NameBlankException e) {
					System.out.println("Item name cannot be blank! This item will not be added.");
				} 
			}
			return itemsFromFile;
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Cannot find file!");
		}
			
		return itemsFromFile;
	}

	public static void playerSellplayer(Inventory toSell, Inventory toBuy, Item item, int amount) {
		if (!hasEnoughMoneytoBuy(toBuy, item, amount)) {
			System.out.println(toBuy.getPlayerName() + " dont't have enough money to buy this item.");
		} else {
			System.out.println("=========SELL CONFIRMATION=========");
			System.out.println("    Selling " + item.getItemName() + " x" + amount
					+ " to " + toBuy.getPlayerName());
			System.out.println("            for $" + item.getPrice() * amount
					+ "             ");
			System.out.println(" >> Type \"1\" to confirm selling  ");
			System.out.println(" >> Type anything else to cancel ");
			System.out.println("===================================");
			String input = sc.nextLine();
			switch (input) {
			case "1":
				playerSellPlayerConfirmed(toSell, toBuy, item, amount);
				System.out.println("<<TRANSACTION COMPLETE>>");
				break;
			default:
				System.out.println("<<SELL CANCEL>>");
				break;
			}
		}
	}
	
	public static void playerSellPlayerConfirmed(Inventory toSell, Inventory toBuy, Item item, int amount) {
		toSell.setMoney(toSell.getMoney() + item.getPrice() * amount);
		toBuy.setMoney(toBuy.getMoney() - item.getPrice() * amount);
		toSell.removeItem(item, amount);
		toBuy.addItem(item, amount);
	}

	public static void playerSellMarket(Inventory toSell, Item item, int amount) {
		System.out.println("=========SELL CONFIRMATION=========");
		System.out.println("    Selling " + item.getItemName() + " x" + amount
				+ " to market      ");
		System.out.println(
				"            for $" + item.getPrice() * amount + "             ");
		System.out.println(" >> Type \"1\" to confirm selling  ");
		System.out.println(" >> Type anything else to cancel ");
		System.out.println("===================================");
		String input = sc.nextLine();
		switch (input) {
		case "1":
			playerSellMarketConfirmed(toSell, item, amount);
			System.out.println("<<TRANSACTION COMPLETE>>");
			break;
		default:
			System.out.println("<<SELL CANCEL>>");
			break;
		}
	}
	
	public static void playerSellMarketConfirmed(Inventory toSell, Item item, int amount) {
		//FILL CODE
		toSell.setMoney(toSell.getMoney() + item.getPrice() * amount);
		toSell.removeItem(item, amount);
	}
	
	public static void playerBuyMarket(Inventory toBuy, Item item, int amount) {
		if (!ItemUtil.hasEnoughMoneytoBuy(toBuy, item, amount)) {
			System.out.println(toBuy.getPlayerName() + " Dont't have enough money\nto buy this item.");
		} else {
			System.out.println("=========BUY CONFIRMATION=========");
			System.out.println("	" + toBuy.getPlayerName() + " is buying ");
			System.out.println("	" + item.getItemName() + " x" + amount + " for $"
					+ item.getPrice() * amount);
			System.out.println(" >> Type \"1\" to confirm buying  ");
			System.out.println(" >> Type anything else to cancel");
			System.out.println("==================================");
			String input = sc.nextLine();
			switch (input) {
			case "1":
				playerBuyMarketConfirmed(toBuy, item, amount);
				System.out.println("TRANSACTION COMPLETE!");
				break;
			default:
				System.out.println("BUY CANCEL!");
				break;
			}
		}
	}
	
	public static void playerBuyMarketConfirmed(Inventory toBuy, Item item, int amount) {
		//FILL CODE
		toBuy.setMoney(toBuy.getMoney() - item.getPrice() * amount);
		toBuy.addItem(item, amount);
	}

}
