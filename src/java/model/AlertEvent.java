package model;

import java.util.Date;
import org.apache.catalina.User;

public class AlertEvent {

    private int alertId;
    private AlertRule rule;
    private Drug drug;
    private Batch batch;
    private String alertMessage;
    private Date alertDate;
    private String severity;
    private String status;
    private User resolvedBy;
    private Date resolvedDate;

    public AlertEvent() {
    }

    // Getters and Setters
    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public AlertRule getRule() {
        return rule;
    }

    public void setRule(AlertRule rule) {
        this.rule = rule;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(User resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    @Override
    public String toString() {
        return "AlertEvent{" + "alertId=" + alertId + ", rule=" + rule + ", drug=" + drug + ", batch=" + batch + ", alertMessage=" + alertMessage + ", alertDate=" + alertDate + ", severity=" + severity + ", status=" + status + ", resolvedBy=" + resolvedBy + ", resolvedDate=" + resolvedDate + '}';
    }
    
    
}
