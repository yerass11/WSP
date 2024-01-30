package kz.kbtu.oop.projectv2.researcher;

import kz.kbtu.oop.projectv2.enums.Format;
import kz.kbtu.oop.projectv2.enums.NewsTags;
import kz.kbtu.oop.projectv2.news.News;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static kz.kbtu.oop.projectv2.news.News.*;

/**
 * The {@code ResearchPaper} class represents a research paper with information such as title, authors, journal, pages,
 * publication date, DOI, and citations. It provides methods for citations in different formats and managing citations.
 */
public class ResearchPaper {
    private String title;
    private List<Researcher> authors = new ArrayList<>();
    private String journal;
    private int pages;
    private Date publicationDate;
    private String doi;
    private ArrayList<String> citations = new ArrayList<>();



    public ResearchPaper() {}

    public ResearchPaper(String title, String journal, int pages, String doi) {
        this.title = title;
        this.journal = journal;
        this.pages = pages;
        this.doi = doi;
        this.publicationDate = new Date();
    }

    /**
     * Parameterized constructor for creating a research paper with specified details.
     *
     * @param title           The title of the research paper.
     * @param authors         List of authors who contributed to the research paper.
     * @param journal         The text of research paper.
     * @param pages           The number of pages in the research paper.
     * @param publicationDate The date when the research paper was published.
     * @param doi             The Digital Object Identifier (DOI) associated with the research paper.
     * @param citations       List of citations referencing this research paper.
     */
    public ResearchPaper(String title, List<Researcher> authors, String journal, int pages, Date publicationDate, String doi, ArrayList<String> citations) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.doi = doi;
        this.citations = citations;
    }

    public ResearchPaper(String title, String journal, int pages, Date publicationDate, String doi) {
        this.title = title;
        this.journal = journal;
        this.pages = pages;
        this.publicationDate = publicationDate;
        this.doi = doi;
    }


    /**
     * Returned a citation for the research paper based on the specified format.
     * @param format The format of the citation (PLAIN_TEXT or BIBTEX).
     * @return The generated citation as a String.
     */
    public String getCitation(Format format) {
        String s = "";
        if(format == Format.PLAIN_TEXT) {
            for (Researcher r : authors) {
                s += r.getName() + ", ";
            }
            s += "\"" + title + "\" ";
            s += publicationDate.getYear() + ", ";
            s += "pp. " + pages;
            s += ", doi: " + doi;
        }

        else {
            s += "author={";
            for (Researcher r : authors) {
                s += r.getName() + ", ";
            }
            s += "},\n";
            s += "title={" + title + "},\n";
            s += "year={" + publicationDate.getYear() + "},\n";
            s += "pages={" + pages + "},\n";
            s += "doi={" + doi +"}";
        }

        return s;
    }

    /**
     * Publishes the research paper as news by adding it to the list of news articles.
     * @param p The research paper to be published.
     */
    public static void publication(ResearchPaper p){
        News.addNews(new News(p.getTitle(), p.getJournal(), NewsTags.RESEARCH));
    }

    public int getCountCitations(){
        return citations.size();
    }

    public void addCitation(String c){
        citations.add(c);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Researcher> getAuthors() {
        return authors;
    }

    public void addAuthor(Researcher researcher) {
        authors.add(researcher);
    }

    public void setAuthors(List<Researcher> authors) {
        this.authors = authors;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public ArrayList<String> getCitations() {
        return citations;
    }

    public void setCitations(ArrayList<String> citations) {
        this.citations = citations;
    }
}