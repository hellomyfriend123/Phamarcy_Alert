/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Drug {
     private int  drug_id;
     private String drug_code;
     private String drug_name;
     private String active_ingredient;
     private String unit;
     private int min_Stock = 0;
     private boolean is_active;
     private Date created_at;

    public Drug() {
    }

    public Drug(int drug_id, String drug_code, String drug_name, String active_ingredient, String unit, boolean is_active, Date created_at) {
        this.drug_id = drug_id;
        this.drug_code = drug_code;
        this.drug_name = drug_name;
        this.active_ingredient = active_ingredient;
        this.unit = unit;
        this.is_active = is_active;
        this.created_at = created_at;
    }

    

    public int getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(int drug_id) {
        this.drug_id = drug_id;
    }

    public String getDrug_code() {
        return drug_code;
    }

    public void setDrug_code(String drug_code) {
        this.drug_code = drug_code;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getActive_ingredient() {
        return active_ingredient;
    }

    public void setActive_ingredient(String active_ingredient) {
        this.active_ingredient = active_ingredient;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getMin_Stock() {
        return min_Stock;
    }

    public void setMin_Stock(int min_Stock) {
        this.min_Stock = min_Stock;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Drug{" + "drug_id=" + drug_id + ", drug_code=" + drug_code + ", drug_name=" + drug_name + ", active_ingredient=" + active_ingredient + ", unit=" + unit + ", min_Stock=" + min_Stock + ", is_active=" + is_active + ", created_at=" + created_at + '}';
    }
     
     
}
