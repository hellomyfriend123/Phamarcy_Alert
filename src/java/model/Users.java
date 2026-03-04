/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Users {
    private int user_id;
    private String username;
    private String password_hash;
    private Role role;
    private boolean is_active;
    private Date createDate;

    public Users() {
    }

    public Users(int user_id, String username, String password_hash, Role role, boolean is_active, Date createDate) {
        this.user_id = user_id;
        this.username = username;
        this.password_hash = password_hash;
        this.role = role;
        this.is_active = is_active;
        this.createDate = createDate;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Users{" + "user_id=" + user_id + ", username=" + username + ", password_hash=" + password_hash + ", role=" + role + ", is_active=" + is_active + ", createDate=" + createDate + '}';
    }
    
    
}
