package kz.kbtu.oop.projectv2.researcher;

import kz.kbtu.oop.projectv2.exceptions.NonResearcherException;
import kz.kbtu.oop.projectv2.users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ResearchProject} class represents a research project with a specific topic,
 * a list of published research papers, and a list of participating researchers.
 */
public class ResearchProject {
    private String topic;
    private List<ResearchPaper> publishedPapers = new ArrayList<>();
    private List<Researcher> participants = new ArrayList<>();


    public ResearchProject() {
    }

    public ResearchProject(String topic, List<ResearchPaper> publishedPapers, List<Researcher> participants) {
        this.topic = topic;
        this.publishedPapers = publishedPapers;
        this.participants = participants;
    }

    public ResearchProject(String topic) {
        this.topic = topic;
    }

    /**
     * Adds a participant to the list of researchers associated with the research project.
     *
     * @param participant The user to be added as a participant.
     * @throws NonResearcherException If the participant is not an instance of the Researcher class.
     */
    public void addParticipants(User participant) throws NonResearcherException {
        if (participant instanceof Researcher){
            this.participants.add((Researcher) participant);
        }
        else {
            throw new NonResearcherException("only a researcher can be a part of a project");
        }
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<ResearchPaper> getPublishedPapers() {
        return publishedPapers;
    }

    public void addPublishedPapers(ResearchPaper researchPaper) {
        this.publishedPapers.add(researchPaper);
    }

    public List<Researcher> getParticipants() {
        return participants;
    }

    public void setPublishedPapers(List<ResearchPaper> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public void setParticipants(List<Researcher> participants) {
        this.participants = participants;
    }
}
