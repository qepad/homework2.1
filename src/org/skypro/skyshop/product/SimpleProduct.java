package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int price;


    public SimpleProduct(String title, int price) {
        super(title);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getTitle() +
                ": " +
                this.price +
                " руб.";
    }


}
