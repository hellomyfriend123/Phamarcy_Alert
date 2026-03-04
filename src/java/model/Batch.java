package model;

import java.util.Date;

public class Batch {

    private int batchId;
    private Drug drug; // Object thay vì drugId
    private String batchNumber;
    private Date manufactureDate;
    private Date expDate;
    private Date createdAt;

    public Batch() {
    }

    public Batch(int batchId, Drug drug, String batchNumber, Date manufactureDate, Date expDate, Date createdAt) {
        this.batchId = batchId;
        this.drug = drug;
        this.batchNumber = batchNumber;
        this.manufactureDate = manufactureDate;
        this.expDate = expDate;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Batch{" + "batchId=" + batchId + ", drug=" + drug + ", batchNumber=" + batchNumber + ", manufactureDate=" + manufactureDate + ", expDate=" + expDate + ", createdAt=" + createdAt + '}';
    }

}
