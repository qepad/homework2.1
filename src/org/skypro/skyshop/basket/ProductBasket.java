package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;

public class ProductBasket {

    private final List<Product> basket;
    private static int countOfSpecial = 0;
    private List<Product> deletedProducts;

    private static final Random random = new Random();
    private static String[] titles = {"морковь", "картошка", "капуста", "огурец", "помидор", "яблоко", "баклажан", "тунец", "авокадо", "колбаса"};


    // создает массив, данные хранятся в виде товар+цена
    public ProductBasket() {
        this.basket = new LinkedList<>();
    }

    // добавляет товар в корзину
    public void addProduct(Product product) {
        this.basket.add(product);
        System.out.println("добавлен товар \"" + product.getTitle() + "\", цена: " + product.getPrice() + " руб.");

    }


    // считает стоимость товаров в корзине
    public int getBasketPrice() {
        int sum = 0;

        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            sum += element.getPrice();
        }

        return sum;
    }

    // печатает содержимое корзины и общую стоимость, если корзина не пуста
    public void printBasket() {
        countOfSpecial = 0;
        for (Product basket : basket) {
            if (!this.basket.isEmpty()) {
                System.out.println(basket);
            }
        }
        if (!basket.isEmpty()) {
            System.out.println("итого: " + getBasketPrice() + " руб.");
            System.out.println("специальных продуктов: " + getCountOfSpecial());
        } else {
            System.out.println("в корзине пусто");
        }
    }

    // проверяет, есть ли товар с указанным названием в массиве
    public boolean checkProduct(String title) {
        boolean checkProduct = false;
        for (Product basket : basket) {
            if (!this.basket.isEmpty() && basket.getTitle().equals(title)) {
                checkProduct = true;
            }
        }
        return checkProduct;
    }

    // удаляет товары из корзины
    public void cleanBasket() {
        basket.clear();
        countOfSpecial = 0;
        System.out.println("корзина очищена");
    }

    public List<Product> delete(String name) {
        deletedProducts = new LinkedList<>();

        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getTitle().equals(name)) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        return deletedProducts;
    }

    public void printDeleted() {
        for (Product deleted : deletedProducts) {
            if (!deletedProducts.isEmpty()) {
                System.out.println(deleted);
                System.out.println("удаленных продуктов: " + deletedProducts.size());
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.println("удаленных продуктов нет");
        }
    }

    public int getCountOfSpecial() {
        for (Product basket : basket) {
            if (!this.basket.isEmpty() && basket.isSpecial()) {
                countOfSpecial++;
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