package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public abstract class Product implements Searchable {

    private final UUID id;
    protected final String name;

    public Product(UUID id, String name) throws IllegalArgumentException {
        this.id = id;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Не задано наименование продукта (" + this.getClass().getSimpleName() + ")");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getContentType() {
        return "Product";
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public UUID getID() {
        return this.id;
    }
}