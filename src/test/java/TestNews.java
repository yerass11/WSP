import kz.kbtu.oop.projectv2.enums.NewsTags;
import kz.kbtu.oop.projectv2.news.News;
import kz.kbtu.oop.projectv2.news.NewsComparatorCountOfComments;
import kz.kbtu.oop.projectv2.news.NewsComparatorDate;
import kz.kbtu.oop.projectv2.news.NewsList;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestNews {
    @Test
    void newsUnitTest(){
        News n1 = new News("first news", "blabalvlala!", NewsTags.ACADEMIC);
        News n2 = new News("Sharshadynbba?", "JYLAMA!", NewsTags.RESEARCH);
        News n3 = new News("Sharshadynbba?", "JYLAMA!", NewsTags.RESEARCH, new Date(2000, 1, 1));
        News n4 = new News("last news", "nyamnyam!", NewsTags.RESEARCH, new Date(-200, 1, 1));

        NewsList newsArray = new NewsList();

        newsArray.add(n1);
        newsArray.add(n2);
        newsArray.add(n3);
        newsArray.add(n4);


        newsArray.sort();
        System.out.println(newsArray);

        System.out.println("\n");

        newsArray.sort(new NewsComparatorDate());
        System.out.println(newsArray);

        System.out.println("\n");

        newsArray.sort(new NewsComparatorCountOfComments());
        System.out.println(newsArray);

        System.out.println("\n");
    }
}
