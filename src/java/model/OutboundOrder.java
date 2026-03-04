package model;

import java.util.Date;
import java.util.List;
import org.apache.catalina.User;

public class OutboundOrder {
    private int outboundId;
    private String department;
    private User createdBy;
    private Date createdAt;
    private String notes;
    private List<OutboundLine> lines;
    
    public OutboundOrder() {
    }
    
    public OutboundOrder(int outboundId, String department, User createdBy, Date createdAt, String notes) {
        this.outboundId = outboundId;
        this.department = department;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.notes = notes;
    }
    
    // Getters and Setters
    public int getOutboundId() {
        return outboundId;
    }
    
    public void setOutboundId(int outboundId) {
        this.outboundId = outboundId;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
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
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public List<OutboundLine> getLines() {
        return lines;
    }
    
    public void setLines(List<OutboundLine> lines) {
        this.lines = lines;
    }
    
    // Get total quantity
    public int getTotalQuantity() {
        if (lines == null || lines.isEmpty()) return 0;
        return lines.stream().mapToInt(OutboundLine::getQuantity).sum();
    }
    
    @Override
    public String toString() {
        return "OutboundOrder{" + "outboundId=" + outboundId + ", department=" + department + '}';
    }
}