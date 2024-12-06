
import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private int itemCode;
    private String itemName;
    private int itemQty;

    public Item() {
    }

    // Three-argument constructor
    public Item(int code, String name, int qty) {
        this.itemCode = code;
        this.itemName = name;
        this.itemQty = qty;
    }

    // Getters
    public int getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemQty() {
        return itemQty;
    }

    // Method to display all items in the cart
    public static void display(ArrayList<Item> cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty");
        } else {
            for (Item item : cart) {
                System.out.println("Item code: " + item.getItemCode());
                System.out.println("Item name: " + item.getItemName());
                System.out.println("Item quantity: " + item.getItemQty());
            }
        }
    }
}

public class Card {
    public static void main(String[] args) {
        ArrayList<Item> cart = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Shopping cart menu");
            System.out.println("1. Insert new item in cart");
            System.out.println("2. Remove an item from cart");
            System.out.println("3. View cart items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Insert item
                    System.out.print("Enter item code: ");
                    int code = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter item quantity: ");
                    int qty = sc.nextInt();
                    cart.add(new Item(code, name, qty));
                    break;

                case 2: // Remove item
                    System.out.print("Enter the code of an item: ");
                    int removeCode = sc.nextInt();
                    boolean removed = false;
                    for (int i = 0; i < cart.size(); i++) {
                        if (cart.get(i).getItemCode() == removeCode) {
                            cart.remove(i);
                            removed = true;
                            break;
                        }
                    }
                    if (removed) {
                        System.out.println("Remaining items in cart..");
                        Item.display(cart);
                    } else {
                        System.out.println("Item not found");
                    }
                    break;

                case 3: // View items
                    Item.display(cart);
                    break;

                case 4: // Exit
                    System.out.println("Thank you!!!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}