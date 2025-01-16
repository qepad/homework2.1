package org.skypro.skyshop.product;

public abstract class Product {

    private String title;
    protected static int countOfSpecial = 1;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getCountOfSpecial() {
        return countOfSpecial;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}
