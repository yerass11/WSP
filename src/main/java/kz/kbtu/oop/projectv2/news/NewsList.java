package kz.kbtu.oop.projectv2.news;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NewsList {
    private ArrayList<News> allNews;

    public NewsList() {
        this.allNews = new ArrayList<>();
    }

    public void add(News n){
        allNews.add(n);
    }

    public void sort(){
        Collections.sort(allNews);
    }

    public ArrayList<News> sort(Comparator<News> c){
        if (allNews != null) {
            Collections.sort(allNews, c);
        }
        return allNews;
    }

    @Override
    public String toString(){
        String s = "";
        for (News n : allNews){
            s += n.toString() + "\n";
        }
        return s;
    }

}
