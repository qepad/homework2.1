package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    private String search;

    public BestResultNotFound(String message) {
        super(message);
    }
}
