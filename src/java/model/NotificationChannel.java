package model;

import org.apache.catalina.User;

public class NotificationChannel {
    private int channelId;
    private User user;
    private String channelType; // EMAIL, TELEGRAM, SMS
    private String channelAddress;
    private boolean isActive;
    
    public NotificationChannel() {
    }
    
    public NotificationChannel(int channelId, User user, String channelType, String channelAddress, boolean isActive) {
        this.channelId = channelId;
        this.user = user;
        this.channelType = channelType;
        this.channelAddress = channelAddress;
        this.isActive = isActive;
    }
    
    // Getters and Setters
    public int getChannelId() {
        return channelId;
    }
    
    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getChannelType() {
        return channelType;
    }
    
    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
    
    public String getChannelAddress() {
        return channelAddress;
    }
    
    public void setChannelAddress(String channelAddress) {
        this.channelAddress = channelAddress;
    }
    
    public boolean isIsActive() {
        return isActive;
    }
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public String toString() {
        return "NotificationChannel{" + "channelId=" + channelId + ", user=" + user.getUsername() + 
               ", type=" + channelType + ", address=" + channelAddress + '}';
    }
}