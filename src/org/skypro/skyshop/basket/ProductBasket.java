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
        basket.computeIfAbsent(product.getTitle(), k -> new LinkedList<>()).add(product);
        System.out.println("добавлен товар \"" + product.getTitle() + "\", цена: " + product.getPrice() + " руб.");

    }


    // считает стоимость товаров в корзине
    public int getBasketPrice() {
        return basket.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }


    // печатает содержимое корзины и общую стоимость, если корзина не пуста
    public void printBasket() {
        countOfSpecial = getSpecialCount();

        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        basket.forEach((key, products) -> System.out.println(key + ": " + products));

        System.out.println("итого: " + getBasketPrice() + " руб.");
        System.out.println("специальных продуктов: " + countOfSpecial);

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
        return Optional.ofNullable(basket.remove(name))
                .orElse(new LinkedList<>());
    }

    private int getSpecialCount() {
        return (int) basket.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public String generateTitle() {
        return titles[random.nextInt(0, titles.length)];
    }

    public int generatePrice() {
        return random.nextInt(100, 500);
    }


}