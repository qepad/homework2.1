package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    private String search;

    public BestResultNotFound(String message) {
        super(message);
    }

//    public BestResultNotFound(String search) {
//        this.search = search;
//    }
//
//    @Override
//    public String toString() {
//        return "для слова \"" + search + "\" не найдено подходящего объекта";
//    }
}
