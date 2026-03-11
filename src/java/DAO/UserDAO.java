/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import model.Users;
import model.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.User;

/**
 *
 * @author DELL
 */
public class UserDAO extends DBContext {
    
    private RoleDAO roleDAO = new RoleDAO();
    
    private final String GET_ALL_SQL = "SELECT * FROM Users ORDER BY user_id DESC";
    private final String GET_BY_ID_SQL = "SELECT * FROM Users WHERE user_id = ?";
    private final String GET_BY_USERNAME_SQL = "SELECT * FROM Users WHERE username = ?";
    private final String AUTHENTICATE_SQL = "SELECT * FROM Users WHERE username = ? AND password_hash = ? AND is_active = 1";
    private final String ADD_SQL = "INSERT INTO Users (username, password_hash, full_name, role_id, is_active) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Users SET full_name = ?, role_id = ?, is_active = ? WHERE user_id = ?";
    private final String CHANGE_PASSWORD_SQL = "UPDATE Users SET password_hash = ? WHERE user_id = ?";
    private final String DELETE_SQL = "DELETE FROM Users WHERE user_id = ?";
    private final String SEARCH_SQL = "SELECT * FROM Users WHERE username LIKE ? OR full_name LIKE ?";
    private final String GET_BY_ROLE_SQL = "SELECT * FROM Users WHERE role_id = ? AND is_active = 1";
    
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
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
    
    public User getById(int id) {
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
    
    public User getByUsername(String username) {
        try {
            PreparedStatement stm = c.prepareStatement(GET_BY_USERNAME_SQL);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User authenticate(String username, String passwordHash) {
        try {
            PreparedStatement stm = c.prepareStatement(AUTHENTICATE_SQL);
            stm.setString(1, username);
            stm.setString(2, passwordHash);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return mapResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean add(User user) {
        try {
            PreparedStatement stm = c.prepareStatement(ADD_SQL);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getFullName());
            
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(User user) {
        try {
            PreparedStatement stm = c.prepareStatement(UPDATE_SQL);
            stm.setString(1, user.getFullName());
            stm.setString(2, user.getName());
            stm.setString(3, user.getPassword());
            
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Đổi mật khẩu
    public boolean changePassword(int userId, String newPasswordHash) {
        try {
            PreparedStatement stm = c.prepareStatement(CHANGE_PASSWORD_SQL);
            stm.setString(1, newPasswordHash);
            stm.setInt(2, userId);
            
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Xóa user
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
    
    // Tìm kiếm user
    public List<User> search(String keyword) {
        List<User> list = new ArrayList<>();
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
    
    // Lấy users theo role
    public List<User> getByRoleId(int roleId) {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(GET_BY_ROLE_SQL);
            stm.setInt(1, roleId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(mapResultSet(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Map ResultSet to User
    private User mapResultSet(ResultSet rs) throws Exception {
        Users user = new Users();
        user.setUser_id(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword_hash(rs.getString("password_hash"));
        user.setUsername(rs.getString("full_name"));
        
        int roleId = rs.getInt("role_id");
        Role role = roleDAO.getById(roleId);
        user.setRole(role);
        
        user.setIs_active(rs.getBoolean("is_active"));
        user.setCreateDate(rs.getTimestamp("created_at"));
        return (User) user;
        
    }
   
    }
