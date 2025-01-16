package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Random;

public class ProductBasket {

    private final Product[] basket;
    private static int countOfSpecial = 0;


    // создает массив, данные хранятся в виде товар+цена
    public ProductBasket() {
        this.basket = new Product[5];
    }

    // добавляет товар в пустую ячейку массива
    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                System.out.println("добавлен товар \"" + product.getTitle() + "\", цена: " + product.getPrice() + " руб.");
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
        for (Product basket : basket) {
            if (basket != null) {
                System.out.println(basket);
            }
        }
        if (basket[0] != null) {
            System.out.println("итого: " + getBasketPrice() + " руб.");
            System.out.println("специальных продуктов: " + getCountOfSpecial());
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
        countOfSpecial = 0;
        System.out.println("корзина очищена");
    }

    public int getCountOfSpecial() {
        for (Product basket : basket) {
            if (basket != null && basket.isSpecial()) {
                countOfSpecial++;
            }
        }
        return countOfSpecial;
    }


}
