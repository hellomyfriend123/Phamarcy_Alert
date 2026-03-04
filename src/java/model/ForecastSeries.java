package model;

import java.util.Date;
import java.util.List;

public class ForecastSeries {
    private int seriesId;
    private Drug drug;
    private Date forecastDate;
    private String horizon; // WEEKLY, MONTHLY
    private String modelVersion;
    private Date createdAt;
    private List<ForecastPoint> forecastPoints;
    
    public ForecastSeries() {
    }
    
    public ForecastSeries(int seriesId, Drug drug, Date forecastDate, String horizon, 
                          String modelVersion, Date createdAt) {
        this.seriesId = seriesId;
        this.drug = drug;
        this.forecastDate = forecastDate;
        this.horizon = horizon;
        this.modelVersion = modelVersion;
        this.createdAt = createdAt;
    }
    
    // Getters and Setters
    public int getSeriesId() {
        return seriesId;
    }
    
    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }
    
    public Drug getDrug() {
        return drug;
    }
    
    public void setDrug(Drug drug) {
        this.drug = drug;
    }
    
    public Date getForecastDate() {
        return forecastDate;
    }
    
    public void setForecastDate(Date forecastDate) {
        this.forecastDate = forecastDate;
    }
    
    public String getHorizon() {
        return horizon;
    }
    
    public void setHorizon(String horizon) {
        this.horizon = horizon;
    }
    
    public String getModelVersion() {
        return modelVersion;
    }
    
    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public List<ForecastPoint> getForecastPoints() {
        return forecastPoints;
    }
    
    public void setForecastPoints(List<ForecastPoint> forecastPoints) {
        this.forecastPoints = forecastPoints;
    }
    
    @Override
    public String toString() {
        return "ForecastSeries{" + "seriesId=" + seriesId + ", drug=" + drug.getDrug_name() + 
               ", forecastDate=" + forecastDate + '}';
    }
}