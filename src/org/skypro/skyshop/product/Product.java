package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
