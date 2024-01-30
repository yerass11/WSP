package kz.kbtu.oop.projectv2.analytics;

import java.util.*;

public class Report {
    private static final Set<Report> reportRegistry = new HashSet<>();
    private static int reportCounter = 1;


    private int reportId;
    private String title;
    private Date creationDate;
    private List<String> contents; // Each string could represent a line or section in the report

    // Constructor
    public Report(String title) {
        this.reportId = reportCounter++;
        this.title = title;
        this.creationDate = new Date(); // sets the creation date to the current date
        this.contents = new ArrayList<>();
        reportRegistry.add(this);
    }

    public Report(String title, String... contents) {
        this(title);
        this.contents.addAll(Arrays.asList(contents));
    }

    // Method to add content to the report
    public void addContent(String content) {
        contents.add(content);
    }

    // Method to get the full report as a String
    public String getFullReport() {
        return null;
    }

    public int getReportId() {
        return reportId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (reportId != report.reportId) return false;
        if (!Objects.equals(title, report.title)) return false;
        if (!Objects.equals(creationDate, report.creationDate))
            return false;
        return Objects.equals(contents, report.contents);
    }

    @Override
    public int hashCode() {
        int result = reportId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        return result;
    }
}

