package kz.kbtu.oop.projectv2.news;

import java.util.Comparator;

public class NewsComparatorDate implements Comparator<News> {
    @Override
    public int compare(News o1, News o2) {
        return -o1.getDate().compareTo(o2.getDate());
        // минус используется для изменения направления сортировки. чтобы отсортировать в убывающем хронологическом порядке

    }
}
