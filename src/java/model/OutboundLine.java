package model;

public class OutboundLine {

    
    private int outboundLineId;
    private OutboundOrder outboundOrder;
    private Batch batch;
    private int quantity;
    
    public OutboundLine() {
    }
    
    public OutboundLine(int outboundLineId, OutboundOrder outboundOrder, Batch batch, int quantity) {
        this.outboundLineId = outboundLineId;
        this.outboundOrder = outboundOrder;
        this.batch = batch;
        this.quantity = quantity;
    }
    
    // Getters and Setters
    public int getOutboundLineId() {
        return outboundLineId;
    }
    
    public void setOutboundLineId(int outboundLineId) {
        this.outboundLineId = outboundLineId;
    }
    
    public OutboundOrder getOutboundOrder() {
        return outboundOrder;
    }
    
    public void setOutboundOrder(OutboundOrder outboundOrder) {
        this.outboundOrder = outboundOrder;
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
    
    @Override
    public String toString() {
        return "OutboundLine{" + "outboundLineId=" + outboundLineId + ", batch=" + batch.getBatchNumber() + 
               ", quantity=" + quantity + '}';
    }
}