/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Role;

/**
 *
 * @author DELL
 */
public class RoleDAO extends DBContext {
    
    private final String GET_ALL_SQL = "SELECT * FROM Roles ORDER BY role_id";
    private final String GET_BY_ID_SQL = "SELECT * FROM Roles WHERE role_id = ?";
    private final String GET_BY_NAME_SQL = "SELECT * FROM Roles WHERE role_name = ?";
    private final String ADD_SQL = "INSERT INTO Roles (role_name) VALUES (?)";
    private final String UPDATE_SQL = "UPDATE Roles SET role_name = ? WHERE role_id = ?";
    private final String DELETE_SQL = "DELETE FROM Roles WHERE role_id = ?";
    
    public List<Role> getAll() {
        List<Role> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(GET_ALL_SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Role role = new Role(
                    rs.getInt("role_id"),
                    rs.getString("role_name")
                );
                list.add(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Role getById(int id) {
        try {
            PreparedStatement stm = c.prepareStatement(GET_BY_ID_SQL);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Role(
                    rs.getInt("role_id"),
                    rs.getString("role_name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Role getByName(String name) {
        try {
            PreparedStatement stm = c.prepareStatement(GET_BY_NAME_SQL);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Role(
                    rs.getInt("role_id"),
                    rs.getString("role_name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean add(Role role) {
        try {
            PreparedStatement stm = c.prepareStatement(ADD_SQL);
            stm.setString(1, role.getRole_name());
            
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(Role role) {
        try {
            PreparedStatement stm = c.prepareStatement(UPDATE_SQL);
            stm.setString(1, role.getRole_name());
            stm.setInt(2, role.getRole_id());
            
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
    
    public static void main(String[] args) {
        RoleDAO dao = new RoleDAO();
        System.out.println("=== TEST GET ALL ROLES ===");
        for (Role r : dao.getAll()) {
            System.out.println(r.getRole_id() + " - " + r.getRole_name());
        }
    }
}