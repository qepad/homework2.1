package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Random;

public class ProductBasket {

    private static Random random = new Random();
    private static String[] titles = {"морковь", "картошка", "капуста", "огурец", "помидор", "яблоко", "баклажан", "тунец", "авокадо", "колбаса"};
    private final Product[] basket;

    // создает массив, данные хранятся в виде товар+цена
    public ProductBasket() {
        this.basket = new Product[5];
    }

    // добавляет товар в пустую ячейку массива
    public void addProduct(String title, int price) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = new Product(title, price);
                System.out.println("добавлен товар \"" + title + "\", цена: " + price + " руб.");
                return;
            } else if (basket[basket.length - 1] != null) {
                System.out.println("невозможно добавить продукт");
                return;
            }
        }
    }

    // считает стоимость товаров в корзине
    public int getBasketPrice() {
        int sum = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                sum += basket[i].getPrice();
            }
        }
        return sum;
    }

    // печатает содержимое корзины и общую стоимость, если корзина не пуста
    public void printBasket() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                System.out.println(basket[i].getTitle() + ": " + basket[i].getPrice() + " руб.");
            }
        }
        if (basket[0] != null) {
            System.out.println("итого: " + getBasketPrice() + " руб.");
        } else {
            System.out.println("в корзине пусто");
        }
    }

    // проверяет, есть ли товар с указанным названием в массиве
    public boolean checkProduct(String title) {
        boolean checkProduct = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null && basket[i].getTitle().equals(title)) {
                checkProduct = true;
            }
        }
        return checkProduct;
    }

    // удаляет товары из корзины
    public void cleanBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
        System.out.println("корзина очищена");
    }

    // генерация продуктов и добавление их в массив, оставляет 1 свободную ячейку
    public void generateProducts() {
        for (int i = 0; i < basket.length - 1; i++) {
            basket[i] = new Product(titles[random.nextInt(0, titles.length)], random.nextInt(100, 500));
        }
    }


}
