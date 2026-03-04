package model;

import java.util.Date;
import org.apache.catalina.User;

public class CaseTicket {

    private int caseId;
    private AlertEvent alert;
    private User assignedTo;
    private String priority; // LOW, MEDIUM, HIGH, CRITICAL
    private String description;
    private String actionTaken;
    private String evidencePath;
    private String status; // OPEN, IN_PROGRESS, RESOLVED, CLOSED
    private Date createdAt;
    private Date closedAt;
    private User closedBy;

    public CaseTicket() {
    }

    public CaseTicket(int caseId, AlertEvent alert, User assignedTo, String priority, String description,
            String actionTaken, String evidencePath, String status, Date createdAt,
            Date closedAt, User closedBy) {
        this.caseId = caseId;
        this.alert = alert;
        this.assignedTo = assignedTo;
        this.priority = priority;
        this.description = description;
        this.actionTaken = actionTaken;
        this.evidencePath = evidencePath;
        this.status = status;
        this.createdAt = createdAt;
        this.closedAt = closedAt;
        this.closedBy = closedBy;
    }

    // Getters and Setters
    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public AlertEvent getAlert() {
        return alert;
    }

    public void setAlert(AlertEvent alert) {
        this.alert = alert;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getEvidencePath() {
        return evidencePath;
    }

    public void setEvidencePath(String evidencePath) {
        this.evidencePath = evidencePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public User getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(User closedBy) {
        this.closedBy = closedBy;
    }

    @Override
    public String toString() {
        return "CaseTicket{" + "caseId=" + caseId + ", alert=" + alert.getAlertId()
                + ", status=" + status + ", priority=" + priority + '}';
    }
}
