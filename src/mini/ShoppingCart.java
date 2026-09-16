package mini;
import java.util.*;
public class ShoppingCart {
    private final Map<String, CartItem> items = new HashMap<>();
    private final TaxCalculator taxCalculator = new DefaultTaxCalculator();

    public void addItem(Item item, int quantity) {
        items.merge(item.getName(), new CartItem(item, quantity), (existing, newItem) -> {
            existing.setQuantity(existing.getQuantity() + quantity);
            return existing;
        });
    }

    public void editItem(String itemName, int newQuantity) {
        if (!items.containsKey(itemName)) throw new NoSuchElementException("Item not in cart");
        items.get(itemName).setQuantity(newQuantity);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public double getRawTotal() {
        return items.values().stream().mapToDouble(CartItem::getSubtotal).sum();
    }

    public double calculateTotal(String state, ShippingMethod shipping) {
        double subtotal = getRawTotal();
        double tax = taxCalculator.calculateTax(subtotal, state);
        double shippingCost = (subtotal == 0) ? 0 :
            (shipping == ShippingMethod.STANDARD && subtotal > 50 ? 0 : shipping.getCost());

        return subtotal + tax + shippingCost;
    }

    public void checkout() {
        System.out.println("Transaction completed");
        items.clear();
    }
}