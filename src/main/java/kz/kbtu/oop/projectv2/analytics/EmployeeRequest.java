package kz.kbtu.oop.projectv2.analytics;

import kz.kbtu.oop.projectv2.users.employees.Employee;

import java.util.Date;

public class EmployeeRequest {
    private String requestId;
    private Employee requester;
    private String requestType; // Could be an enum in a more detailed implementation
    private String description;
    private Date requestDate;
    private boolean isSignedOff;

    // Constructor
    public EmployeeRequest(String requestId, Employee requester, String requestType, String description) {
        this.requestId = requestId;
        this.requester = requester;
        this.requestType = requestType;
        this.description = description;
        this.requestDate = new Date(); // sets the request date to the current date
        this.isSignedOff = false;
    }

    // Method to sign off the request
    public void signOff() {
        isSignedOff = true;
    }

    // Getters and setters for requestId, requester, requestType, description, requestDate, and isSignedOff
    public String getRequestId() { return null; }
    public void setRequestId(String requestId) {
    }
    public Employee getRequester() { return null; }
    public void setRequester(Employee requester) { }
    public String getRequestType() { return null; }
    public void setRequestType(String requestType) { }
    public String getDescription() { return null; }
    public void setDescription(String description) { }
    public Date getRequestDate() { return null; }
    public void setRequestDate(Date requestDate) { }
    public boolean isSignedOff() {
        return isSignedOff;
    }
    public void setSignedOff(boolean isSignedOff) { }

    // Other request-specific methodsreturn null;
}

