package model;

import java.util.Date;

public class ForecastPoint {
    private int pointId;
    private ForecastSeries series;
    private Date periodStart;
    private Date periodEnd;
    private int predictedQuantity;
    private Integer lowerBound;
    private Integer upperBound;
    private Integer actualQuantity;
    
    public ForecastPoint() {
    }
    
    public ForecastPoint(int pointId, ForecastSeries series, Date periodStart, Date periodEnd, 
                         int predictedQuantity, Integer lowerBound, Integer upperBound, Integer actualQuantity) {
        this.pointId = pointId;
        this.series = series;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.predictedQuantity = predictedQuantity;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.actualQuantity = actualQuantity;
    }
    
    // Getters and Setters
    public int getPointId() {
        return pointId;
    }
    
    public void setPointId(int pointId) {
        this.pointId = pointId;
    }
    
    public ForecastSeries getSeries() {
        return series;
    }
    
    public void setSeries(ForecastSeries series) {
        this.series = series;
    }
    
    public Date getPeriodStart() {
        return periodStart;
    }
    
    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }
    
    public Date getPeriodEnd() {
        return periodEnd;
    }
    
    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }
    
    public int getPredictedQuantity() {
        return predictedQuantity;
    }
    
    public void setPredictedQuantity(int predictedQuantity) {
        this.predictedQuantity = predictedQuantity;
    }
    
    public Integer getLowerBound() {
        return lowerBound;
    }
    
    public void setLowerBound(Integer lowerBound) {
        this.lowerBound = lowerBound;
    }
    
    public Integer getUpperBound() {
        return upperBound;
    }
    
    public void setUpperBound(Integer upperBound) {
        this.upperBound = upperBound;
    }
    
    public Integer getActualQuantity() {
        return actualQuantity;
    }
    
    public void setActualQuantity(Integer actualQuantity) {
        this.actualQuantity = actualQuantity;
    }
    
    // Calculate forecast error if actual is available
    public Double getForecastError() {
        if (actualQuantity == null) return null;
        return Math.abs(predictedQuantity - actualQuantity) / (double) actualQuantity;
    }
    
    @Override
    public String toString() {
        return "ForecastPoint{" + "pointId=" + pointId + ", period=" + periodStart + " to " + periodEnd + 
               ", predicted=" + predictedQuantity + '}';
    }
}