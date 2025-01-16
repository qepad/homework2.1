package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basicPrice;
    private int discount;


    public DiscountedProduct(String title, int basicPrice, int discount) {
        super(title);
        this.basicPrice = basicPrice;
        this.discount = discount;
    }


    public int getBasicPrice () {
        return this.basicPrice;
    }

    @Override
    public int getPrice() {
        return basicPrice - (basicPrice * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        countOfSpecial++;
        return true;
    }

    @Override
    public String toString() {
        return getTitle() +
                ": " +
                getPrice() +
                " руб. (скидка " +
                this.discount +
                "%, цена без скидки - " +
                getBasicPrice() +
                " руб.)";
    }
}
