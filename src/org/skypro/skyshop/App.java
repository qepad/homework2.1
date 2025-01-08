package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.Random;

public class App {


    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket(); // создание корзины
        productBasket.generateProducts(); // заполнение ее 4 рандомными продуктами
        productBasket.addProduct("маракуйя", 300); // добавление нового продукта
        productBasket.addProduct("яблоко", 100); // добавление продукта в заполненную корзину
        productBasket.printBasket(); // печать содержимого корзины

        // получение стоимости корзины
        System.out.println("стоимость товаров в корзине - " + productBasket.getBasketPrice() + " руб.");

        // поиск товара
        String search = "маракуйя";
        System.out.println("продукт с названием \"" + search + "\" есть в корзине - " + productBasket.checkProduct(search));

        productBasket.cleanBasket(); // очистка корзины
        productBasket.printBasket(); // печать содержимого пустой корзины

        // получение стоимости пустой корзины
        System.out.println("стоимость товаров в корзине - " + productBasket.getBasketPrice() + " руб.");

        // поиск товара в пустой корзине
        String search2 = "овощ";
        System.out.println("продукт с названием \"" + search2 + "\" есть в корзине - " + productBasket.checkProduct(search2));



    }
}
