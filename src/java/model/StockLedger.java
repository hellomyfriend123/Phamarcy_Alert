/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class StockLedger {

    public class InventoryBalance {

        private int balanceId;
        private Batch batch;
        private InventoryLocation location;
        private int quantity;
        private int ledgerId;
        private Drug drug;
        private int changeQty;
        private String referenceType; 
        private int referenceId;
        private Users createdBy;
        private Date createdAt;

        public InventoryBalance() {
        }

        public InventoryBalance(int balanceId, Batch batch, InventoryLocation location, int quantity) {
            this.balanceId = balanceId;
            this.batch = batch;
            this.location = location;
            this.quantity = quantity;
        }

        public InventoryBalance(int balanceId, Batch batch, InventoryLocation location, int quantity, int ledgerId, Drug drug, int changeQty, String referenceType, int referenceId, Users createdBy, Date createdAt) {
            this.balanceId = balanceId;
            this.batch = batch;
            this.location = location;
            this.quantity = quantity;
            this.ledgerId = ledgerId;
            this.drug = drug;
            this.changeQty = changeQty;
            this.referenceType = referenceType;
            this.referenceId = referenceId;
            this.createdBy = createdBy;
            this.createdAt = createdAt;
        }

        public int getLedgerId() {
            return ledgerId;
        }

        public void setLedgerId(int ledgerId) {
            this.ledgerId = ledgerId;
        }

        public Drug getDrug() {
            return drug;
        }

        public void setDrug(Drug drug) {
            this.drug = drug;
        }

        public int getChangeQty() {
            return changeQty;
        }

        public void setChangeQty(int changeQty) {
            this.changeQty = changeQty;
        }

        public String getReferenceType() {
            return referenceType;
        }

        public void setReferenceType(String referenceType) {
            this.referenceType = referenceType;
        }

        public int getReferenceId() {
            return referenceId;
        }

        public void setReferenceId(int referenceId) {
            this.referenceId = referenceId;
        }

        public Users getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Users createdBy) {
            this.createdBy = createdBy;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }
        
        

        // Getters and Setters
        public int getBalanceId() {
            return balanceId;
        }

        public void setBalanceId(int balanceId) {
            this.balanceId = balanceId;
        }

        public Batch getBatch() {
            return batch;
        }

        public void setBatch(Batch batch) {
            this.batch = batch;
        }

        public InventoryLocation getLocation() {
            return location;
        }

        public void setLocation(InventoryLocation location) {
            this.location = location;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "InventoryBalance{" + "balanceId=" + balanceId + ", batch=" + batch + ", location=" + location + ", quantity=" + quantity + ", ledgerId=" + ledgerId + ", drug=" + drug + ", changeQty=" + changeQty + ", referenceType=" + referenceType + ", referenceId=" + referenceId + ", createdBy=" + createdBy + ", createdAt=" + createdAt + '}';
        }
        
        
    }

  

}
