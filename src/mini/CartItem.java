package mini;

public class CartItem {
    private final Item item;
    private int quantity;

    public CartItem(Item item, int quantity) {
        if (quantity < 1) throw new IllegalArgumentException("Quantity must be at least 1");
        this.item = item;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) throw new IllegalArgumentException("Quantity must be at least 1");
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return item.getPrice() * quantity;
    }

    public Item getItem() {
        return item;
    }
}