import kz.kbtu.oop.projectv2.enums.Format;
import kz.kbtu.oop.projectv2.exceptions.NonResearcherException;
import kz.kbtu.oop.projectv2.researcher.ResearchPaper;
import kz.kbtu.oop.projectv2.researcher.ResearchProject;
import kz.kbtu.oop.projectv2.researcher.Researcher;
import kz.kbtu.oop.projectv2.users.User;
import kz.kbtu.oop.projectv2.users.students.UndergraduateStudent;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class ResearcherTest {
    @Test
    void researcherUnitTest() throws NonResearcherException {
        Researcher researcher1 = new Researcher("22B030388", "Nurdaulet");


        ResearchPaper paper1 = new ResearchPaper("Paper1", "Journal A", 10, "10.1109/EDUCON52537.2022.9766691");
        ResearchPaper paper2 = new ResearchPaper("Paper2", "Journal B", 8, "44.71234/EDUCON31.2019.12345");
        paper1.addCitation("abcdjqddkq");
        paper1.addCitation("jhgdakld");

        paper2.addCitation("abcdjqddkq");
        paper2.addCitation("adhub1in2");
        paper2.addCitation("adaljdhu");

        researcher1.addPaper(paper1);
        researcher1.addPaper(paper2);

        researcher1.printPapers(Comparator.comparing(ResearchPaper::getCountCitations));

        researcher1.calculateHIndex();
        System.out.println(researcher1.gethIndex());

        System.out.println(paper1.getCitation(Format.PLAIN_TEXT) + "\n\n\n");
        System.out.println(paper2.getCitation(Format.BIBTEX));

        ResearchPaper.publication(paper1);


        User undergraduateStudent = new UndergraduateStudent();
        ResearchProject researchProject = new ResearchProject();
        try {
            researchProject.addParticipants(undergraduateStudent);
        }
        catch (NonResearcherException n){
            n.printStackTrace();
        }
    }
}
