package org.skypro.skyshop.model.product;

import java.util.Objects;
import java.util.UUID;

public class SimpleProduct extends Product {

    private final int price;

    public SimpleProduct(UUID id, String name, int price) {
        super(id, name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0 (" + this.getClass().getSimpleName() + ")");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Продукт: " + getName() + ", стоимость: " + getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SimpleProduct that = (SimpleProduct) o;
        return getName().equals(that.getName()) && getPrice() == that.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}
