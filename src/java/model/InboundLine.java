package model;

public class InboundLine {
    private int inboundLineId;
    private InboundOrder inboundOrder;
    private Batch batch;
    private int quantity;
    private double unitPrice;
    
    public InboundLine() {
    }
    
    public InboundLine(int inboundLineId, InboundOrder inboundOrder, Batch batch, int quantity, double unitPrice) {
        this.inboundLineId = inboundLineId;
        this.inboundOrder = inboundOrder;
        this.batch = batch;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    
    // Getters and Setters
    public int getInboundLineId() {
        return inboundLineId;
    }
    
    public void setInboundLineId(int inboundLineId) {
        this.inboundLineId = inboundLineId;
    }
    
    public InboundOrder getInboundOrder() {
        return inboundOrder;
    }
    
    public void setInboundOrder(InboundOrder inboundOrder) {
        this.inboundOrder = inboundOrder;
    }
    
    public Batch getBatch() {
        return batch;
    }
    
    public void setBatch(Batch batch) {
        this.batch = batch;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public double getTotalPrice() {
        return quantity * unitPrice;
    }
    
    @Override
    public String toString() {
        return "InboundLine{" + "inboundLineId=" + inboundLineId + ", batch=" + batch.getBatchNumber() + 
               ", quantity=" + quantity + '}';
    }
}