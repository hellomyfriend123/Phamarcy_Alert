/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Batch;
import model.Drug;

/**
 *
 * @author DELL
 */
public class BatchDAO extends DBContext {
    
    private DrugDao drugDAO = new DrugDao();
    
    private final String GET_ALL_SQL = "SELECT * FROM Batches ORDER BY batch_id DESC";
    private final String GET_BY_ID_SQL = "SELECT * FROM Batches WHERE batch_id = ?";
    private final String GET_BY_DRUG_SQL = "SELECT * FROM Batches WHERE drug_id = ? ORDER BY exp_date";
    private final String GET_NEAR_EXPIRY_SQL = "SELECT * FROM Batches WHERE exp_date BETWEEN GETDATE() AND DATEADD(day, ?, GETDATE()) ORDER BY exp_date";
    private final String ADD_SQL = "INSERT INTO Batches (drug_id, batch_number, manufacture_date, exp_date) VALUES (?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Batches SET batch_number = ?, manufacture_date = ?, exp_date = ? WHERE batch_id = ?";
    private final String DELETE_SQL = "DELETE FROM Batches WHERE batch_id = ?";
    private final String SEARCH_SQL = "SELECT b.* FROM Batches b JOIN Drugs d ON b.drug_id = d.drug_id WHERE b.batch_number LIKE ? OR d.drug_name LIKE ?";
    
    public List<Batch> getAll() {
        List<Batch> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(GET_ALL_SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Batch getById(int id) {
        try {
            PreparedStatement stm = c.prepareStatement(GET_BY_ID_SQL);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Batch> getByDrugId(int drugId) {
        List<Batch> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(GET_BY_DRUG_SQL);
            stm.setInt(1, drugId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Batch> getNearExpiryBatches(int days) {
        List<Batch> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(GET_NEAR_EXPIRY_SQL);
            stm.setInt(1, days);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean add(Batch batch) {
        try {
            PreparedStatement stm = c.prepareStatement(ADD_SQL);
            stm.setInt(1, batch.getDrug().getDrug_id());
            stm.setString(2, batch.getBatchNumber());
            stm.setDate(3, batch.getManufactureDate() != null ? java.sql.Date.valueOf(batch.getManufactureDate().toString()) : null);
            stm.setDate(4, java.sql.Date.valueOf(batch.getExpDate().toString()));
            
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(Batch batch) {
        try {
            PreparedStatement stm = c.prepareStatement(UPDATE_SQL);
            stm.setString(1, batch.getBatchNumber());
            stm.setDate(2, batch.getManufactureDate() != null ? java.sql.Date.valueOf(batch.getManufactureDate().toString()) : null);
            stm.setDate(3, java.sql.Date.valueOf(batch.getExpDate().toString()));
            stm.setInt(4, batch.getBatchId());
            
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(int id) {
        try {
            PreparedStatement stm = c.prepareStatement(DELETE_SQL);
            stm.setInt(1, id);
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Batch> search(String keyword) {
        List<Batch> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SEARCH_SQL);
            String pattern = "%" + keyword + "%";
            stm.setString(1, pattern);
            stm.setString(2, pattern);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    private Batch mapResultSet(ResultSet rs) throws Exception {
        Batch batch = new Batch();
        batch.setBatchId(rs.getInt("batch_id"));
        
        int drugId = rs.getInt("drug_id");
        Drug drug = drugDAO.getByID(drugId);
        batch.setDrug(drug);
        
        batch.setBatchNumber(rs.getString("batch_number"));
        batch.setManufactureDate(rs.getDate("manufacture_date"));
        batch.setExpDate(rs.getDate("exp_date"));
        batch.setCreatedAt(rs.getTimestamp("created_at"));
        
        return batch;
    }
    
  
    }
