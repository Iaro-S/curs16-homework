package ro.fasttrackit.homework16;

import java.util.Objects;

public class Electronics implements ShopItem {
    private final String name;
    private final int price;
    private final Category category;

    public Electronics(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronics)) return false;
        Electronics that = (Electronics) o;
        return getPrice() == that.getPrice() && Objects.equals(getName(), that.getName()) && getCategory() == that.getCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getCategory());
    }
}
