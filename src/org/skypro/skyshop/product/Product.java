package org.skypro.skyshop.product;

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
