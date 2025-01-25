package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Random;

public abstract class Product implements Searchable {

    private String title;

    public Product(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return this.title;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}
