package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE = 100;

    public FixPriceProduct (String title) {
        super(title);
    }

    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        countOfSpecial++;
        return true;
    }

    @Override
    public String toString() {
        return getTitle() +
                ": фиксированная цена " +
                getPrice() +
                " руб.";
    }

}
