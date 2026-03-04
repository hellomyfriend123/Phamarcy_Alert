package model;

public class InventoryBalance {

    private int balanceId;
    private Batch batch;
    private InventoryLocation location;
    private int quantity;

    public InventoryBalance() {
    }

    public InventoryBalance(int balanceId, Batch batch, InventoryLocation location, int quantity) {
        this.balanceId = balanceId;
        this.batch = batch;
        this.location = location;
        this.quantity = quantity;
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
        return "InventoryBalance{" + "balanceId=" + balanceId + ", batch=" + batch + ", location=" + location + ", quantity=" + quantity + '}';
    }

}
