package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Random;

public abstract class Product implements Searchable {

    private String title;


    public Product(String title) {
        if (!title.isBlank() && !title.isEmpty() && title != null) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("название продукта не может быть пустым");
        }
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
