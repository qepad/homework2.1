package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthComparison = Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
        if (lengthComparison == 0) {
            return o1.getSearchTerm().compareTo(o2.getSearchTerm());
        }

        return lengthComparison;
    }
}
