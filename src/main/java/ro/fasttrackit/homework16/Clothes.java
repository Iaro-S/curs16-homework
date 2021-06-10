package ro.fasttrackit.homework16;

import java.util.Objects;

public class Clothes implements ShopItem {
    private final String name;
    private final int price;
    private final Category category;

    public Clothes(String name, int price, Category category) {
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
        return "Clothes{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clothes)) return false;
        Clothes clothes = (Clothes) o;
        return getPrice() == clothes.getPrice() && Objects.equals(getName(), clothes.getName()) && getCategory() == clothes.getCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getCategory());
    }
}
