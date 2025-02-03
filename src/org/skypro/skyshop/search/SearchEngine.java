package org.skypro.skyshop.search;

public class SearchEngine {

    private final Searchable[] searchables;
    private final int MAX_RESULTS = 5; // макс.количество результатов поиска


    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[MAX_RESULTS];
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null && searchables[i].getSearchTerm().contains(query)) {
                result[i] = searchables[i];
            }
            if (i >= MAX_RESULTS - 1) {
                break;
            }
        }
        return result;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                System.out.println("добавлено: " + searchable);
                return;
            } else if (searchables[searchables.length - 1] != null) {
                System.out.println("error");
                return;
            }
        }
    }

    public Searchable searchBest(String search) throws BestResultNotFound {
        if (search == null || search.isBlank() || searchables == null) {
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
