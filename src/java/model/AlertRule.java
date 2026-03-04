package model;

import java.util.Date;
import org.apache.catalina.User;

public class AlertRule {

    private int ruleId;
    private String ruleName;
    private String ruleType; 
    private Drug drug; 
    private String severity; 
    private Integer thresholdValue;
    private Integer timeBeforeExpiry;
    private boolean isActive;
    private User createdBy;
    private Date createdAt;

    public AlertRule() {
    }

    // Getters and Setters
    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Integer getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(Integer thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public Integer getTimeBeforeExpiry() {
        return timeBeforeExpiry;
    }

    public void setTimeBeforeExpiry(Integer timeBeforeExpiry) {
        this.timeBeforeExpiry = timeBeforeExpiry;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AlertRule{" + "ruleId=" + ruleId + ", ruleName=" + ruleName + ", ruleType=" + ruleType + ", drug=" + drug + ", severity=" + severity + ", thresholdValue=" + thresholdValue + ", timeBeforeExpiry=" + timeBeforeExpiry + ", isActive=" + isActive + ", createdBy=" + createdBy + ", createdAt=" + createdAt + '}';
    }
    
    
}
