package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Random;

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
        productBasket.addProduct(product6); // добавление товара в полную корзину
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

        productBasket.cleanBasket(); // очистка корзины
        productBasket.printBasket(); // печать содержимого пустой корзины
        System.out.println();

        // получение стоимости пустой корзины
        System.out.println("стоимость товаров в корзине - " + productBasket.getBasketPrice() + " руб.");


    }
}
