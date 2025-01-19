package org.skypro.skyshop.product;

import java.util.Random;

public abstract class Product {

    private String title;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}
