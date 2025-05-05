package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        createElementsAndFillCollections();
    }

    public Map<UUID, Product> getProducts(){
        return this.products;
    }

    public Map<UUID, Article> getArticles() {
        return this.articles;
    }

    public Map<UUID, Searchable> getAllElements(){
        Map<UUID, Searchable> mapElements = new HashMap<>();
        mapElements.putAll(products);
        mapElements.putAll(articles);
        return mapElements;
    }

    private void createElementsAndFillCollections() {

        UUID id = null;

        try {
            id = UUID.randomUUID();
            Product p1 = new SimpleProduct(id,"Мяч футзальный (Мяч для футбола в зале)", 500);
            products.put(id, p1);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p11 = new SimpleProduct(id, "Мяч футзальный (Мяч для футбола в зале)", 500);
            products.put(id, p11);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p2 = new SimpleProduct(id, "Мяч баскетбольный", 0);
            products.put(id, p2);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p22 = new SimpleProduct(id, "Мяч баскетбольный (размер 5)", 350);
            products.put(id, p22);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p23 = new SimpleProduct(id, "Мяч баскетбольный (размер 3)", 250);
            products.put(id, p23);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p24 = new SimpleProduct(id, "Мяч баскетбольный (размер 4)", 300);
            products.put(id, p24);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p3 = new DiscountedProduct(id, "Набор мячей для тенниса", 200, 101);
            products.put(id, p3);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p31 = new DiscountedProduct(id, "Набор мячей для тенниса", 200, 10);
            products.put(id, p31);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p32 = new DiscountedProduct(id, "Набор мячей для тенниса", 200, 20);
            products.put(id, p32);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p33 = new DiscountedProduct(id, "Набор мячей для тенниса", 200, 20);
            products.put(id, p33);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p4 = new DiscountedProduct(id, "Мяч волейбольный", 0, 25);
            products.put(id, p4);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p5 = new SimpleProduct(id, "", 200);
            products.put(id, p5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p6 = new FixPriceProduct(id, "Мяч волейбольный");
            products.put(id, p6);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p7 = new SimpleProduct(id, "Коврик для йоги", 1400);
            products.put(id, p7);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Product p8 = new SimpleProduct(id, "Сушилка для обуви", 400);
            products.put(id, p8);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Article a1 = new Article(id, "Выбираем обувь для футбола",
                    "Играть в бутсах однозначно комфортнее, чем в кроссовках. " +
                            "Форма обуви важна, чтобы чувствовать мяч " +
                            "(принимать его, двигать его и особенно бить по нему). " +
                            "Это как есть макароны ложкой – можно, но не так удобно." +
                            " Если ты с друзьями на шашлыках и решил десять минут побегать " +
                            "в футбол — нормально, в остальных ситуациях лучше бутсы.");
            articles.put(id, a1);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Article a2 = new Article(id, "Чекап здоровья перед бегом",
                    """
                            Классическая диспансеризация (в обычной поликлинике или, при возможности, в клинике спортивной медицины);
                            Расширенный биохимический анализ крови с последующей расшифровкой от грамотного спортивного врача;
                            Обследование вен на варикоз;
                            Обследование сердца;
                            Оценка состояния предыдущих травм, если такие были.""");
            articles.put(id, a2);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Article a3 = new Article(id, "Что нужно купить, чтобы начать играть в большой теннис?",
                    "Ракетка для тенниса;\n" +
                    "Теннисные мячи;\n" +
                    "Обувь для тенниса;\n" +
                    "Одежда для тенниса;\n" +
                    "Сумка для теннисного снаряжения.");
            articles.put(id, a3);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        try {
            id = UUID.randomUUID();
            Article a31 = new Article(id, "Что нужно купить, чтобы начать играть в большой теннис?",
                    "Ракетка для тенниса;\n" +
                    "Теннисные мячи;\n" +
                    "Обувь для тенниса;\n" +
                    "Одежда для тенниса;\n" +
                    "Сумка для теннисного снаряжения.");
            articles.put(id, a31);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

    }
}
