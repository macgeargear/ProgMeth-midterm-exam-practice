package logic;

public class ItemCounter {
    private Item item;
    private int amount;

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }

    public int getCount() { 
        return this.amount;
    }

    public void setCount(int count) {
        if (count < 0) count = 0;
        this.amount = count;
    }

    public ItemCounter(Item item) {
        this.setItem(item);
        this.setCount(1);
    }

    public ItemCounter(Item item, int count) {
        this.setItem(item);
        this.setCount(Math.max(1, count));

    }

    public String toString() {
        return this.getItem() + " x" + this.getCount();
    }
}
