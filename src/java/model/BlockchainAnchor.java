package model;

import java.util.Date;

public class BlockchainAnchor {
    private int anchorId;
    private String transactionHash;
    private Integer blockNumber;
    private Date timestamp;
    private String dataType; // STOCK_LEDGER, ALERT_EVENT, etc.
    private int dataId;
    private Date createdAt;
    
    public BlockchainAnchor() {
    }
    
    public BlockchainAnchor(int anchorId, String transactionHash, Integer blockNumber, Date timestamp, 
                            String dataType, int dataId, Date createdAt) {
        this.anchorId = anchorId;
        this.transactionHash = transactionHash;
        this.blockNumber = blockNumber;
        this.timestamp = timestamp;
        this.dataType = dataType;
        this.dataId = dataId;
        this.createdAt = createdAt;
    }
    
    // Getters and Setters
    public int getAnchorId() {
        return anchorId;
    }
    
    public void setAnchorId(int anchorId) {
        this.anchorId = anchorId;
    }
    
    public String getTransactionHash() {
        return transactionHash;
    }
    
    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }
    
    public Integer getBlockNumber() {
        return blockNumber;
    }
    
    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getDataType() {
        return dataType;
    }
    
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    
    public int getDataId() {
        return dataId;
    }
    
    public void setDataId(int dataId) {
        this.dataId = dataId;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return "BlockchainAnchor{" + "anchorId=" + anchorId + ", txHash=" + transactionHash + 
               ", dataType=" + dataType + ", dataId=" + dataId + '}';
    }
}