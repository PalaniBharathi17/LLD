import java.util.Map;

public class OrderService {
    public void buyItem(Cart cart, InventoryService inv) {
        // Validate
        for (Map.Entry<Item, Integer> e : cart.getItems().entrySet()) {
            if (e.getValue() > e.getKey().getQuantity()) {
                System.out.println("Not enough stock for " + e.getKey().getName());
                return;
            }
        }
        // Deduct stock
        for (Map.Entry<Item, Integer> e : cart.getItems().entrySet()) {
            e.getKey().setQuantity(e.getKey().getQuantity() - e.getValue());
        }
        System.out.println("Order placed successfully for ₹" + cart.getTotal());
        cart.clear();
    }
}
