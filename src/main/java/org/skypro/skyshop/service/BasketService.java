package org.skypro.skyshop.service;

import org.skypro.skyshop.dto.BasketItem;
import org.skypro.skyshop.dto.UserBasket;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BasketService {

    private final ProductBasket basket;
    private final StorageService storageService;

    public BasketService(StorageService storageService, ProductBasket productBasket) {
        this.basket = productBasket;
        this.storageService = storageService;
    }

    public void addItem(UUID id) {
        if (storageService.getProductById(id).isPresent()) {
            basket.addProducts(id);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Map<UUID, Integer> showBasket() {
        return basket.getBasket();
    }

    public UserBasket getUserBasket() {
        List<BasketItem> items = basket.getBasket().entrySet().stream()
                .map(entry -> {
                    Product product = storageService.getProductById(entry.getKey()).orElseThrow();
                    return new BasketItem(product, entry.getValue());
                })
                .toList();
        return new UserBasket(items);
    }

}
