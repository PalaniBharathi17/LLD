import java.util.*;

public class InventoryService {
    private List<Item> items = new ArrayList<>();

    public void addItem(String name, double price, int qty) {
        items.add(new Item(name, price, qty));
    }

    public void updateItem(String name, int newQty) {
        for (Item i : items) {
                if (i.getName().equalsIgnoreCase(name)) {
                i.setQuantity(newQty);
                System.out.println("Updated quantity for " + name);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public void listInventory() {
        if (items.isEmpty()) {
            System.out.println("No items available.");
            return;
        }
        int idx = 1;
        for (Item i : items) {
            System.out.println(idx++ + ". " + i);
        }
    }

    public Item getItemByIndex(int index) {
        if (index < 1 || index > items.size()) return null;
        return items.get(index - 1);
    }
}
