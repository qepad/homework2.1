package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> basket;
    private static int countOfSpecial = 0;

    private static final Random random = new Random();
    private static String[] titles = {"морковь", "картошка", "капуста", "огурец", "помидор", "яблоко", "баклажан", "тунец", "авокадо", "колбаса"};


    // создает массив, данные хранятся в виде товар+цена
    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    // добавляет товар в корзину
    public void addProduct(Product product) {
        List<Product> products = basket.getOrDefault(product.getTitle(), new LinkedList<>());
        products.add(product);
        basket.put(product.getTitle(), products);
        System.out.println("добавлен товар \"" + product.getTitle() + "\", цена: " + product.getPrice() + " руб.");

    }


    // считает стоимость товаров в корзине
    public int getBasketPrice() {
        int sum = 0;

        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                sum += product.getPrice();
            }
        }

        return sum;
    }

    // печатает содержимое корзины и общую стоимость, если корзина не пуста
    public void printBasket() {
        countOfSpecial = 0;

        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("итого: " + getBasketPrice() + " руб.");
        System.out.println("специальных продуктов: " + getCountOfSpecial());

    }

    // проверяет, есть ли товар с указанным названием в массиве
    public boolean checkProduct(String title) {
        boolean checkProduct = false;

        if (!basket.isEmpty() && basket.containsKey(title)) {
            checkProduct = true;
        }

        return checkProduct;
    }

    // удаляет товары из корзины
    public void cleanBasket() {
        basket.clear();
        countOfSpecial = 0;
        System.out.println("корзина очищена");
    }

    // удаляет товары по названию
    public List<Product> delete(String name) {
        List<Product> deletedProducts = basket.remove(name);

        if (deletedProducts == null) {
            deletedProducts = new LinkedList<>();
        }

        return deletedProducts;
    }

    public int getCountOfSpecial() {

        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product.isSpecial()) {
                    countOfSpecial++;
                }
            }
        }

        return countOfSpecial;
    }

    public String generateTitle() {
        return titles[random.nextInt(0, titles.length)];
    }

    public int generatePrice() {
        return random.nextInt(100, 500);
    }


}