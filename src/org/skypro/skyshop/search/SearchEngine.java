package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {

    private final List<Searchable> searchables;


    public SearchEngine() {
        this.searchables = new LinkedList<>();
    }

    public Map<String, List<Searchable>> search(String query) {
        Map<String, List<Searchable>> result = new TreeMap<>();
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                List<Searchable> list = result.getOrDefault(searchable.getSearchTerm(), new LinkedList<>());
                list.add(searchable);
                result.put(searchable.getSearchTerm(), list);
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
        System.out.println("добавлено: " + searchable);
    }

    public Searchable searchBest(String search) throws BestResultNotFound {
        if (search == null || search.isBlank() || searchables.isEmpty()) {
            throw new BestResultNotFound("поисковый запрос или список объектов пусты");
        }

        Searchable result = null;
        int maxCount = -1;
        boolean found = false;

        for (Searchable searchable : searchables) {
            if (searchable == null) {
                continue;
            }

            String str = searchable.getSearchTerm();
            if (str == null) {
                continue;
            }

            String substr = search;
            int count = 0;
            int index = 0;

            while ((index = str.indexOf(substr, index)) != -1) {
                count++;
                index += substr.length();
            }

            if (count > 0) {
                found = true;
            }

            if (count > maxCount) {
                maxCount = count;
                result = searchable;
            }
        }

        if (!found) {
            throw new BestResultNotFound("для слова \"" + search + "\" не найдено подходящего объекта");
        }

        return result;

    }

}
