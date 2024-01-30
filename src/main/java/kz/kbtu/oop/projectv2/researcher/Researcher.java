package kz.kbtu.oop.projectv2.researcher;

import kz.kbtu.oop.projectv2.users.User;
import kz.kbtu.oop.projectv2.users.employees.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The {@code Researcher} class represents a researcher, extending the {@link User} class.
 * It contains methods and properties related to research papers and h-index calculation.
 */
public class Researcher extends User {
    private List<ResearchPaper> papers = new ArrayList<>();
    int hIndex;

    public Researcher() {}

    public Researcher(String id, String fullname) {
        super(id, fullname);
    }

    public Researcher(String id, String fullname, String email, String password) {
        super(id, fullname, email, password);
    }


    /**
     * Prints the list of research papers sorted based on the provided comparator.
     *
     * @param comparator The comparator used to define the sorting order.
     */
    public void printPapers(Comparator<ResearchPaper> comparator) {
        papers.sort(comparator);
        for(ResearchPaper rp : papers){
            System.out.println(rp);
        }
    }


    /**
     * Calculates the h-index of the researcher based on the number of citations of their papers.
     */
    public void calculateHIndex() {
        hIndex = 0;
        papers.sort(Comparator.comparingInt(ResearchPaper::getCountCitations).reversed());
        for (int i = 0; i < papers.size(); i++) {
            int citations = papers.get(i).getCitations().size();

            if (citations >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
    }

    public List<ResearchPaper> getPapers() {
        return papers;
    }

    public void addPaper(ResearchPaper paper) {
        papers.add(paper);
    }

    public int gethIndex() {
        return hIndex;
    }
}
