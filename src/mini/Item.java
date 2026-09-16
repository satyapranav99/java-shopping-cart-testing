package mini;

public class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        if (price < 0 || price > 99999.99) throw new IllegalArgumentException("Price out of bounds");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}