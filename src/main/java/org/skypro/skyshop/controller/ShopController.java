package org.skypro.skyshop.controller;

import org.skypro.skyshop.dto.UserBasket;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;
    private final BasketService basketService;
    private final ProductBasket productBasket;

    public ShopController(StorageService storageService, SearchService searchService, BasketService basketService,
                          ProductBasket productBasket) {
        this.storageService = storageService;
        this.searchService = searchService;
        this.basketService = basketService;
        this.productBasket = productBasket;
    }

    @GetMapping
    public String Greetings(){
        return "Welcome to SkyShop";
    }

    @GetMapping("/products")
    public Map<UUID, Product> getAllProducts(){
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public Map<UUID, Article> getAllArticles(){
        return storageService.getArticles();
    }

    @GetMapping("/all")
    public Map<UUID, Searchable> getAllElements(){
        return storageService.getAllElements();
    }

    @GetMapping("/search")
    public List<SearchResult> getFoundElements(@RequestParam("pattern") String pattern){
        return searchService.search(pattern);
    }

    @GetMapping("/basket/{id}")
    public String addProduct(@PathVariable("id") UUID id){
        basketService.addItem(id);
        return "Продукт успешно добавлен";
    }

    @GetMapping("/basket")
    public UserBasket showBasket(){
        return basketService.getUserBasket();
    }
}
