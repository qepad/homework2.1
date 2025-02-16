package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket(); // создание корзины

        Product product1 = new SimpleProduct(productBasket.generateTitle(), productBasket.generatePrice());
        Product product2 = new DiscountedProduct(productBasket.generateTitle(), productBasket.generatePrice(), 5);
        Product product3 = new FixPriceProduct(productBasket.generateTitle());
        Product product4 = new FixPriceProduct(productBasket.generateTitle());
        Product product5 = new SimpleProduct(productBasket.generateTitle(), productBasket.generatePrice());
        Product product6 = new SimpleProduct(productBasket.generateTitle(), productBasket.generatePrice());

        System.out.println("добавление товаров в корзину");
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.addProduct(product6);
        System.out.println();

        System.out.println("печать корзины");
        productBasket.printBasket();
        System.out.println();

        // получение стоимости корзины
        System.out.println("стоимость товаров в корзине - " + productBasket.getBasketPrice() + " руб.");
        System.out.println();

        // поиск товара
        String search = "яблоко";
        System.out.println("продукт с названием \"" + search + "\" есть в корзине - " + productBasket.checkProduct(search));
        System.out.println();

        List<Product> deleted = productBasket.delete("морковь"); // удаление по названию
        if (!deleted.isEmpty()) {
            System.out.println("список удаленных продуктов:\n" + deleted);
            System.out.println("удаленных продуктов: " + deleted.size());
        } else {
            System.out.println("удаленных продуктов нет");
        }
        System.out.println();

        System.out.println("корзина после удаления по названию");
        productBasket.printBasket();

        System.out.println();
        productBasket.cleanBasket(); // очистка корзины
        productBasket.printBasket(); // печать содержимого пустой корзины
        System.out.println();

        // получение стоимости пустой корзины
        System.out.println("стоимость товаров в корзине - " + productBasket.getBasketPrice() + " руб.");
        System.out.println();


/*
        search engine
*/

        System.out.println("search engine");
        System.out.println();

        SearchEngine searchEngine = new SearchEngine(15);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        System.out.println();

        Article article1 = new Article("статья о картошке", "картошка лежит под землей, но не очень глубоко");
        Article article2 = new Article("статья о яблоках", "яблоки можно подавать с белым вином или в составе фруктового салата");
        Article article3 = new Article("статья о помидорах", "помидоры растут в огородах, из них делают сок, соус или салат");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        System.out.println();

        String search1 = "яблоко";
        String search2 = "картошка";
        String search3 = "помидор";

        System.out.println("поиск по слову \"" + search1 + "\": " + searchEngine.search(search1));
        System.out.println("поиск по слову \"" + search2 + "\": " + searchEngine.search(search2));
        System.out.println("поиск по слову \"" + search3 + "\": " + searchEngine.search(search3));


/*
        exceptions
*/
        System.out.println();
        System.out.println("exceptions");
        System.out.println();

        try {
            Product productExc1 = new DiscountedProduct("фрукт", 1000, 10);
            Product productExc2 = new SimpleProduct("", 1000);
            Product productExc3 = new SimpleProduct("овощ", 10);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println();

        // объект существует
        String search4 = "картошка";
        try {
            System.out.println("поиск по слову \"" + search4 + "\": " + searchEngine.searchBest(search4));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }

        System.out.println();

        // объекта не существует
        String search5 = "пиво";
        try {
            System.out.println("поиск по слову \"" + search4 + "\": " + searchEngine.searchBest(search5));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }


    }
}
