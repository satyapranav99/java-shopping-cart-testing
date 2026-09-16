package mini;

import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        // TODO: Implement a CLI-based interaction here
        // Use cart.addItem(), editItem(), removeItem(), getItems(), calculateTotal(), checkout()
        // For simplicity, hardcode some Items or allow the user to enter name and price
        System.out.println("Welcome to the Shopping App");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add item to cart");
            System.out.println("2. View cart contents");
            System.out.println("3. Edit item quantity");
            System.out.println("4. Remove item");
            System.out.println("5. Show total (with tax & shipping)");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine());

                    try {
                        cart.addItem(new Item(name, price), qty);
                        System.out.println("Item added successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    for (CartItem ci : cart.getItems()) {
                        System.out.printf("- %s x%d = $%.2f\n",
                            ci.getItem().getName(),
                            ci.getQuantity(),
                            ci.getSubtotal());
                    }
                    break;

                case 3:
                    System.out.print("Enter item name to edit: ");
                    String editName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQty = Integer.parseInt(scanner.nextLine());
                    try {
                        cart.editItem(editName, newQty);
                        System.out.println("Item updated.");
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter item name to remove: ");
                    String removeName = scanner.nextLine();
                    cart.removeItem(removeName);
                    System.out.println("Item removed.");
                    break;

                case 5:
                    System.out.print("Enter your state abbreviation (e.g., IL): ");
                    String state = scanner.nextLine();
                    System.out.print("Shipping method (STANDARD/NEXT_DAY): ");
                    String method = scanner.nextLine().toUpperCase();
                    try {
                        ShippingMethod shipping = ShippingMethod.valueOf(method);
                        double total = cart.calculateTotal(state, shipping);
                        System.out.printf("Total amount (with tax & shipping): $%.2f\n", total);
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    cart.checkout();
                    break;

                case 7:
                    System.out.println("Exiting app. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

      //  System.out.println("Welcome to the Shopping App");
        // ... more CLI logic
    }
}

