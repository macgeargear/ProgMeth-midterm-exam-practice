package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		// TODO	
		this.orderItemList = new ArrayList<OrderItem>();
		this.orderNumber = Order.totalOrderCount;
		Order.totalOrderCount++;
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem
		for (OrderItem o : orderItemList) {
			if (o.getItem().equals(item)) {
				o.increaseItemAmount(amount);
				return o;
			}
		}
		// else create new orderItem with given item and amount, then return the new orderItem
		OrderItem o = new OrderItem(item, amount);
		this.orderItemList.add(o);
		return o;
	}

	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int price = 0;
		for (OrderItem o : orderItemList) {
			price += o.calculateTotalPrice();
		}
		return price;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
