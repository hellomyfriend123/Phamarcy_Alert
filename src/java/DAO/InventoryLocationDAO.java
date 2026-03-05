/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.InventoryLocation;

/**
 *
 * @author DELL
 */
public class InventoryLocationDAO extends DBContext {

    private final String GET_ALL_SQL = "SELECT * FROM InventoryLocations ORDER BY location_id DESC";
    private final String GET_BY_ID_SQL = "SELECT * FROM InventoryLocations WHERE location_id = ?";
    private final String ADD_SQL = "INSERT INTO InventoryLocations (location_name, description) VALUES (?, ?)";
    private final String UPDATE_SQL = "UPDATE InventoryLocations SET location_name = ?, description = ? WHERE location_id = ?";
    private final String DELETE_SQL = "DELETE FROM InventoryLocations WHERE location_id = ?";
    private final String SEARCH_SQL = "SELECT * FROM InventoryLocations WHERE location_name LIKE ? OR description LIKE ?";
    
    public List<InventoryLocation> getAll() {
        List<InventoryLocation> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(GET_ALL_SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                InventoryLocation location = new InventoryLocation(
                    rs.getInt("location_id"),
                    rs.getString("location_name"),
                    rs.getString("description")
                );
                list.add(location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public InventoryLocation getById(int id) {
        try {
            PreparedStatement stm = c.prepareStatement(GET_BY_ID_SQL);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new InventoryLocation(
                    rs.getInt("location_id"),
                    rs.getString("location_name"),
                    rs.getString("description")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean add(InventoryLocation location) {
        try {
            PreparedStatement stm = c.prepareStatement(ADD_SQL);
            stm.setString(1, location.getLocationName());
            stm.setString(2, location.getDescription());
            
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(InventoryLocation location) {
        try {
            PreparedStatement stm = c.prepareStatement(UPDATE_SQL);
            stm.setString(1, location.getLocationName());
            stm.setString(2, location.getDescription());
            stm.setInt(3, location.getLocationId());
            
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
    
    public List<InventoryLocation> search(String keyword) {
        List<InventoryLocation> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SEARCH_SQL);
            String pattern = "%" + keyword + "%";
            stm.setString(1, pattern);
            stm.setString(2, pattern);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                InventoryLocation location = new InventoryLocation(
                    rs.getInt("location_id"),
                    rs.getString("location_name"),
                    rs.getString("description")
                );
                list.add(location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
