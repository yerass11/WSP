package kz.kbtu.oop.projectv2.exceptions;

public class NonResearcherException extends Exception {
    // Exception when a non-researcher tries to join a research project
    public NonResearcherException(String description){
        super(description);
    }
}
