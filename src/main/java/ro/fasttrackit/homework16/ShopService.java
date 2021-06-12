package ro.fasttrackit.homework16;

import java.util.*;

public class ShopService<T extends ShopItem> {
    private final List<T> shopItems = new ArrayList<>();

    public ShopService() {
    }

    public ShopService(List<T> items) {
        if (items != null) {
            this.shopItems.addAll(items);
        }
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(shopItems);
    }

    public void addItem(T item) {
        shopItems.add(item);
    }

    public List<T> findByCategory(Category cat) {
        List<T> result = new ArrayList<>();
        for (T item : shopItems) {
            if (item.getCategory() == cat) {
                result.add(item);
            }
        }
        return result;
    }

    public List<T> findWithLowerPrice(int maxPrice) {
        List<T> result = new ArrayList<>();
        for (T item : shopItems) {
            if (item.getPrice() < maxPrice) {
                result.add(item);
            }
        }
        return result;
    }

    public Optional<ShopItem> findByName(String name) {
        for (ShopItem item : shopItems) {
            if (item.getName().equals(name)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Optional<ShopItem> removeItem(String name) {
        for (ShopItem item : shopItems) {
            if (item.getName().equals(name)) {
                shopItems.remove(name);
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }
}
