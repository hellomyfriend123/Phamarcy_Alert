package model;

import java.util.Date;

public class Notification {
    private int notificationId;
    private AlertEvent alert;
    private NotificationChannel channel;
    private Date sentDate;
    private String status; // SENT, FAILED
    private String errorMessage;
    
    public Notification() {
    }
    
    public Notification(int notificationId, AlertEvent alert, NotificationChannel channel, 
                        Date sentDate, String status, String errorMessage) {
        this.notificationId = notificationId;
        this.alert = alert;
        this.channel = channel;
        this.sentDate = sentDate;
        this.status = status;
        this.errorMessage = errorMessage;
    }
    
    // Getters and Setters
    public int getNotificationId() {
        return notificationId;
    }
    
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }
    
    public AlertEvent getAlert() {
        return alert;
    }
    
    public void setAlert(AlertEvent alert) {
        this.alert = alert;
    }
    
    public NotificationChannel getChannel() {
        return channel;
    }
    
    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }
    
    public Date getSentDate() {
        return sentDate;
    }
    
    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    @Override
    public String toString() {
        return "Notification{" + "notificationId=" + notificationId + ", alert=" + alert.getAlertId() + 
               ", status=" + status + '}';
    }
}