import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProfileService profile = new ProfileService();
        InventoryService inventory = new InventoryService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        while (true) {
            System.out.println("\n--- Super Store ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Enter username: ");
                String user = sc.nextLine();
                System.out.print("Enter password: ");
                String pass = sc.nextLine();
                System.out.print("Are you a seller? (y/n): ");
                boolean isSeller = sc.nextLine().equalsIgnoreCase("y");
                profile.register(user, pass, isSeller);
                System.out.println("Registered successfully!");
            } else if (ch == 2) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();
                User loggedIn = profile.login(u, p);
                if (loggedIn == null) {
                    System.out.println("Invalid credentials.");
                    continue;
                }
                if (loggedIn.isSeller()) {
                    sellerMenu(sc, inventory);
                } else {
                    buyerMenu(sc, inventory, orderService, paymentService);
                }
            } else {
                break;
            }
        }
    }

    private static void sellerMenu(Scanner sc, InventoryService inventory) {
        while (true) {
            System.out.println("\n--- Seller Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. Logout");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                System.out.print("Item name: ");
                String n = sc.nextLine();
                System.out.print("Price: ");
                double p = sc.nextDouble();
                System.out.print("Quantity: ");
                int q = sc.nextInt();
                sc.nextLine();
                inventory.addItem(n, p, q);
            } else if (ch == 2) {
                inventory.listInventory();
                System.out.print("Item name to update: ");
                String n = sc.nextLine();
                System.out.print("New Quantity: ");
                int q = sc.nextInt();
                sc.nextLine();
                inventory.updateItem(n, q);
            } else {
                break;
            }
        }
    }

    private static void buyerMenu(Scanner sc, InventoryService inventory,
                                  OrderService orderService, PaymentService paymentService) {
        Cart cart = new Cart();
        while (true) {
            System.out.println("\n--- Buyer Menu ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add to Cart");
            System.out.println("3. Place Order");
            System.out.println("4. Logout");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                inventory.listInventory();
            } else if (ch == 2) {
                inventory.listInventory();
                System.out.print("Enter item number: ");
                int idx = sc.nextInt();
                System.out.print("Quantity: ");
                int q = sc.nextInt();
                sc.nextLine();
                Item item = inventory.getItemByIndex(idx);
                if (item != null) {
                    cart.addItem(item, q);
                    System.out.println("Added to cart.");
                } else {
                    System.out.println("Invalid item.");
                }
            } else if (ch == 3) {
                double total = cart.getTotal();
                if (total == 0) {
                    System.out.println("Cart is empty.");
                    continue;
                }
                System.out.println("Total amount: ₹" + total);
                paymentService.makePayment(total);
                orderService.buyItem(cart, inventory);
            } else {
                break;
            }
        }
    }
}
