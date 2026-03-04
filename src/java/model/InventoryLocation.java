package model;

public class InventoryLocation {

    private int locationId;
    private String locationName;
    private String description;

    public InventoryLocation() {
    }

    public InventoryLocation(int locationId, String locationName, String description) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.description = description;
    }

    // Getters and Setters
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "InventoryLocation{" + "locationId=" + locationId + ", locationName=" + locationName + ", description=" + description + '}';
    }

}
