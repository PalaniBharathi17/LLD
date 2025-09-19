import java.util.*;

public class Cart {
    private Map<Item, Integer> items = new HashMap<>();

    public void addItem(Item item, int qty) {
        items.put(item, items.getOrDefault(item, 0) + qty);
    }

    public double getTotal() {
        double sum = 0;
        for (Map.Entry<Item, Integer> e : items.entrySet()) {
            sum += e.getKey().getPrice() * e.getValue();
        }
        return sum;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
