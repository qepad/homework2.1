package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {

    private String title;
    private String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return this.title +
                "\n" +
                this.text;
    }
}
