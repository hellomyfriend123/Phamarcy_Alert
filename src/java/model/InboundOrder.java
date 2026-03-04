package model;

import java.util.Date;
import java.util.List;
import org.apache.catalina.User;

public class InboundOrder {
    private int inboundId;
    private Supplier supplier;
    private User createdBy;
    private Date createdAt;
    private String notes;
    private List<InboundLine> lines;
    
    public InboundOrder() {
    }
    
    public InboundOrder(int inboundId, Supplier supplier, User createdBy, Date createdAt, String notes) {
        this.inboundId = inboundId;
        this.supplier = supplier;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.notes = notes;
    }
    
    // Getters and Setters
    public int getInboundId() {
        return inboundId;
    }
    
    public void setInboundId(int inboundId) {
        this.inboundId = inboundId;
    }
    
    public Supplier getSupplier() {
        return supplier;
    }
    
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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
    
    public List<InboundLine> getLines() {
        return lines;
    }
    
    public void setLines(List<InboundLine> lines) {
        this.lines = lines;
    }
    
    // Calculate total amount
    public double getTotalAmount() {
        if (lines == null || lines.isEmpty()) return 0;
        return lines.stream()
                .mapToDouble(line -> line.getQuantity() * line.getUnitPrice())
                .sum();
    }
    
    @Override
    public String toString() {
        return "InboundOrder{" + "inboundId=" + inboundId + ", supplier=" + supplier.getSupplierName() + '}';
    }
}