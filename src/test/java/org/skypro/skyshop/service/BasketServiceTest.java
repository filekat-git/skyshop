package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.dto.BasketItem;
import org.skypro.skyshop.dto.UserBasket;
import org.skypro.skyshop.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    public ProductBasket productBasket;

    @Mock
    public StorageService storageService;

    @InjectMocks
    public BasketService basketService;

    @Test
    public void givenBasket_whenAddingNotExistingElement_thenThrowException() {
        Assertions.assertTrue(storageService.getAllElements().isEmpty());
        Assertions.assertThrows(NoSuchProductException.class, () -> basketService.addItem(UUID.randomUUID()));
    }

    @Test
    public void givenStorageWithElements_whenAddingExistedElement_thenCallAddProductMethod() {
        Map<UUID, Searchable> mapElements = fillTestedService();
        UUID id = mapElements.values().stream().findFirst().get().getID();

        Mockito.when(storageService.getProductById(id))
                .thenReturn(Optional.of((Product) mapElements.values().stream().findFirst().get()));
        basketService.addItem(id);

        Mockito.verify(productBasket, Mockito.times(1)).addProducts(id);
    }

    @Test
    public void givenEmptyProductBasket_whenGetUserBasket_thenReturnEmptyBasket() {
        UserBasket result = basketService.getUserBasket();

        Assertions.assertTrue(productBasket.getBasket().isEmpty());
        Assertions.assertTrue(result.getItems().isEmpty());
    }

    @Test
    public void givenNotEmptyProductBasket_whenGetUserBasket_thenReturnBasket() {
        Map<UUID, Searchable> mapElements = fillTestedService();
        UUID id = mapElements.values().stream().findFirst().get().getID();

        productBasket.addProducts(id);

        UserBasket resultBasket = basketService.getUserBasket();
        List<BasketItem> items = resultBasket.getItems();
        for (BasketItem basketItem : items) {
            Assertions.assertEquals(500, basketItem.getProduct().getPrice());
        }
    }

    private Map<UUID, Searchable> fillTestedService() {

        Map<UUID, Searchable> mapElements = new HashMap<>();
        UUID id = UUID.randomUUID();
        Product p1 = new SimpleProduct(id, "Мяч футзальный (Мяч для футбола в зале)", 500);
        mapElements.put(id, p1);
        id = UUID.randomUUID();
        Product p22 = new SimpleProduct(id, "Мяч баскетбольный (размер 5)", 350);
        mapElements.put(id, p22);

        return mapElements;
    }

}