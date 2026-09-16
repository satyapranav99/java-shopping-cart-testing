package mini;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Apple", 2.0), 3);
        assertEquals(1, cart.getItems().size());
        assertEquals(6.0, cart.getRawTotal(), 0.001);
    }

    @Test
    public void testEditItemQuantity() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Book", 10.0), 1);
        cart.editItem("Book", 5);
        assertEquals(50.0, cart.getRawTotal(), 0.001);
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Pen", 1.0), 2);
        cart.removeItem("Pen");
        assertEquals(0, cart.getItems().size());
    }

    @Test
    public void testCalculateTotalWithTaxAndShipping() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Headphones", 30.0), 1);
        double expected = 30.0 + 1.8 + 10.0; // 6% tax + $10 shipping
        assertEquals(expected, cart.calculateTotal("IL", ShippingMethod.STANDARD), 0.001);
    }

    @Test
    public void testFreeShippingOver50() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Shoes", 60.0), 1);
        double expected = 60.0 + 3.6; // 6% tax, free shipping
        assertEquals(expected, cart.calculateTotal("CA", ShippingMethod.STANDARD), 0.001);
    }

    @Test
    public void testEmptyCartTotalZero() {
        ShoppingCart cart = new ShoppingCart();
        double total = cart.calculateTotal("NY", ShippingMethod.STANDARD);
        assertEquals(0.0, total, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemInvalidQuantity() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Apple", 1.0), 0); // invalid quantity
    }

    @Test(expected = NoSuchElementException.class)
    public void testEditItemThatDoesNotExist() {
        ShoppingCart cart = new ShoppingCart();
        cart.editItem("Ghost", 2); // item does not exist
    }
    @Test
    public void testCartItemSubtotalAccuracy() {
        Item item = new Item("Mouse", 15.0);
        CartItem cartItem = new CartItem(item, 2);
        assertEquals(30.0, cartItem.getSubtotal(), 0.001);
    }

    @Test
    public void testItemGetNameAndPrice() {
        Item item = new Item("Charger", 20.0);
        assertEquals("Charger", item.getName());
        assertEquals(20.0, item.getPrice(), 0.001);
    }

    @Test
    public void testShippingThresholdJustBelowAndAbove50() {
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addItem(new Item("Cable", 49.99), 1); // Just below 50
        double total1 = cart1.calculateTotal("TX", ShippingMethod.STANDARD);
        assertEquals(59.99, total1, 0.001); // $49.99 + $10 shipping (TX = no tax)

        ShoppingCart cart2 = new ShoppingCart();
        cart2.addItem(new Item("Adapter", 50.01), 1); // Just above 50
        double total2 = cart2.calculateTotal("TX", ShippingMethod.STANDARD);
        assertEquals(50.01, total2, 0.001); // Free shipping
    }
}
