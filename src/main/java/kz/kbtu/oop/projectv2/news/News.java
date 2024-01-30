package kz.kbtu.oop.projectv2.news;

import kz.kbtu.oop.projectv2.enums.NewsTags;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The News class represents a news article with a title, content, date, news tag, comments, and comment count.
 * It implements the Comparable interface for sorting based on certain criteria.
 */
public class News implements Comparable<News> {

    // Static list to store all news articles.
    private static final List<News> newsList = new ArrayList<News>();

    // Instance variables
    private String title;
    private String content;
    private Date date;
    private NewsTags newsTag;
    private ArrayList<Comment> comments;
    private int countOfCommnets;

    /**
     * Constructs a News object with the given title, content, and news tag.
     *
     * @param title    The title of the news article.
     * @param content  The content of the news article.
     * @param newsTag  The news tag associated with the article.
     */
    public News(String title, String content, NewsTags newsTag) {
        this.title = title;
        this.content = content;
        this.newsTag = newsTag;
        this.date = new Date();
    }

    /**
     * Constructs a News object with the given title, content, news tag, and date.
     *
     * @param title    The title of the news article.
     * @param content  The content of the news article.
     * @param newsTag  The news tag associated with the article.
     * @param date     The date when the news article was created.
     */
    public News(String title, String content, NewsTags newsTag, @NotNull Date date) {
        this.title = title;
        this.content = content;
        this.newsTag = newsTag;
        this.date = date;
    }

    /**
     * Retrieves the list of comments associated with this news article.
     *
     * @return The list of comments.
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Adds a comment to the list of comments associated with this news article.
     *
     * @param comment The comment to be added.
     */
    public void addComment(Comment comment) {
        this.comments.add(comment);
        this.countOfCommnets++;
    }

    /**
     * Retrieves the count of comments for this news article.
     *
     * @return The count of comments.
     */
    public int getCountOfCommnets() {
        return countOfCommnets;
    }

    /**
     * Retrieves the title of the news article.
     *
     * @return The title of the news article.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the news article.
     *
     * @param title The new title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the content of the news article.
     *
     * @return The content of the news article.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the news article.
     *
     * @param content The new content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Retrieves the date when the news article was created.
     *
     * @return The date of the news article.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the news article.
     *
     * @param date The new date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Adds a news article to the static list of all news articles.
     *
     * @param n The news article to add.
     */
    public static void addNews(News n) {
        newsList.add(n);
    }

    /**
     * Removes a news article from the static list of all news articles.
     *
     * @param n The news article to remove.
     */
    public static void removeNews(News n) {
        newsList.remove(n);
    }

    /**
     * Compares this news article with another news article for sorting purposes.
     * News articles are compared based on their news tag and creation date.
     *
     * @param o The news article to compare to.
     * @return A negative value if this article is less than the other,
     *         a positive value if it is greater, or 0 if they are equal.
     */
    @Override
    public int compareTo(News o) {
        if (this.newsTag == NewsTags.RESEARCH && o.newsTag != NewsTags.RESEARCH) return -1;
        else if (this.newsTag != NewsTags.RESEARCH && o.newsTag == NewsTags.RESEARCH) return 1;
        else if (this.newsTag == NewsTags.RESEARCH && o.newsTag == NewsTags.RESEARCH) return -(this.date.compareTo(o.getDate()));
        return -(this.date.compareTo(o.getDate()));
    }

    /**
     * Returns a string representation of the news article.
     *
     * @return A string containing the title, content, date, news tag, comments, and comment count.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + sdf.format(date) +
                ", newsTag=" + newsTag +
                ", comments=" + comments +
                ", countOfCommnets=" + countOfCommnets +
                '}';
    }
}
