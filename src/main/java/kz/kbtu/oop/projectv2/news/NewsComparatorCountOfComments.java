package kz.kbtu.oop.projectv2.news;

import java.util.Comparator;

public class NewsComparatorCountOfComments implements Comparator<News> {
    @Override
    public int compare(News o1, News o2) {
        return o1.getCountOfCommnets() - o2.getCountOfCommnets();
    }
}
