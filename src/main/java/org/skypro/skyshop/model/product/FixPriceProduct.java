package org.skypro.skyshop.model.product;

import java.util.Objects;
import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE = 100;

    private final int price;

    public FixPriceProduct(UUID id, String name) {
        super(id, name);
        this.price = FIX_PRICE;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукт с фиксированной ценой: " + getName() + ", стоимость: " + getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FixPriceProduct that = (FixPriceProduct) o;
        return getName().equals(that.getName()) && getPrice() == that.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}
