/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.InboundOrder;
import Model.Supplier;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.InboundOrder;
import model.Supplier;
import org.apache.catalina.User;

/**
 *
 * @author DELL
 */
public class InboundOrderDAO extends DBContext {
    
    private SupplierDAO supplierDAO = new SupplierDAO();
    private UserDAO userDAO = new UserDAO();
    
    private final String GET_ALL_SQL = "SELECT * FROM InboundOrders ORDER BY inbound_id DESC";
    private final String GET_BY_ID_SQL = "SELECT * FROM InboundOrders WHERE inbound_id = ?";
    private final String ADD_SQL = "INSERT INTO InboundOrders (supplier_id, created_by, notes) VALUES (?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE InboundOrders SET supplier_id = ?, notes = ? WHERE inbound_id = ?";
    private final String DELETE_SQL = "DELETE FROM InboundOrders WHERE inbound_id = ?";
    private final String SEARCH_SQL = "SELECT i.* FROM InboundOrders i JOIN Suppliers s ON i.supplier_id = s.supplier_id WHERE s.supplier_name LIKE ? OR i.notes LIKE ?";
    
    public List<InboundOrder> getAll() {
        List<InboundOrder> list = new ArrayList<>();
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
    
    public InboundOrder getById(int id) {
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
    
    public boolean add(InboundOrder order) {
        try {
            PreparedStatement stm = c.prepareStatement(ADD_SQL);
            stm.setInt(1, order.getSupplier().getSupplierId());
            stm.setInt(2, order.getCreatedBy().getUsername());
            stm.setString(3, order.getNotes());
            
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(InboundOrder order) {
        try {
            PreparedStatement stm = c.prepareStatement(UPDATE_SQL);
            stm.setInt(1, order.getSupplier().getSupplierId());
            stm.setString(2, order.getNotes());
            stm.setInt(3, order.getInboundId());
            
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
    
    public List<InboundOrder> search(String keyword) {
        List<InboundOrder> list = new ArrayList<>();
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
    
    private InboundOrder mapResultSet(ResultSet rs) throws Exception {
        InboundOrder order = new InboundOrder();
        order.setInboundId(rs.getInt("inbound_id"));
        
        int supplierId = rs.getInt("supplier_id");
        Supplier supplier = supplierDAO;
        order.setSupplier(supplier);
        
        int createdById = rs.getInt("created_by");
        User createdBy = userDAO.getById(createdById);
        order.setCreatedBy(createdBy);
        
        order.setCreatedAt(rs.getTimestamp("created_at"));
        order.setNotes(rs.getString("notes"));
        
        return order;
    }
    
    public static void main(String[] args) {
        InboundOrderDAO dao = new InboundOrderDAO();
        System.out.println("=== TEST GET ALL ===");
        for (InboundOrder o : dao.getAll()) {
            System.out.println(o.getInboundId() + " - " + o.getSupplier().getSupplierName());
        }
    }
}