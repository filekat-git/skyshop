package org.skypro.skyshop.dto;

import java.util.List;

public class UserBasket {

    private final List<BasketItem> items;
    private final long total;

    public UserBasket(List<BasketItem> items) {
        this.items = items;
        this.total = calculateTotal();
    }

    private long calculateTotal() {
        return items.stream().mapToInt(el -> el.getProduct().getPrice() * el.getQuantity())
                .sum();
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public long getTotal() {
        return total;
    }
}


