package logic;

public class OrderItem {
    private Item item;
    private int itemAmount;
    
    public OrderItem(Item item, int itemAmount) {
        this.setItemAmount(itemAmount);
        this.item = item;
    }

    public void increaseItemAmount(int amount) {
        if (amount < 0) return;
        this.setItemAmount(this.getItemAmount() + amount);
    }

    public int calculateTotalPrice() {
        return this.getItemAmount() * this.getItem().getPricePerPiece();
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = Math.max(0, itemAmount);
    }

    public Item getItem() {
        return this.item;
    }

    public int getItemAmount() {
        return this.itemAmount;
    }
}
