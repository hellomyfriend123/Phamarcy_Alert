/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Drug;

/**
 *
 * @author DELL
 */
public class DrugDao extends DBContext {

    public final String GET_ALL_SQL = "select * from [dbo].[Drugs]";
    private final String GET_BY_ID_SQL = "SELECT * FROM Drugs WHERE drug_id = ?";
    private final String GET_BY_CODE_SQL = "SELECT * FROM Drugs WHERE drug_code = ?";
    private final String ADD_SQL = "INSERT INTO [dbo].[Drugs]\n"
            + "           ([drug_code]\n"
            + "           ,[drug_name]\n"
            + "           ,[active_ingredient]\n"
            + "           ,[unit]\n"
            + "           ,[min_stock]\n"
            + "           ,[is_active]\n"
            + "           ,[created_at])\n"
            + "     VALUES\n"
            + "           (?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?)";

    private final String UPDATE_SQL = "UPDATE [dbo].[Drugs]\n"
            + "   SET [drug_code] = ?\n"
            + "      ,[drug_name] = ?\n"
            + "      ,[active_ingredient] = ?\n"
            + "      ,[unit] = ?\n"
            + "      ,[min_stock] = ?\n"
            + "      ,[is_active] = ?\n"
            + "      ,[created_at] = ?\n"
            + " WHERE [drug_id] = ?";

    private final String Delete_SQL = "DELETE FROM [dbo].[Drugs]\n"
            + "      WHERE [drug_id] = ?";

    private final String Search_SQL = "select *\n"
            + "from [dbo].[Drugs]\n"
            + "where [drug_name] like ? or [drug_code] like ? or [active_ingredient] like ?";

    public List<Drug> getAll() {
        List<Drug> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(GET_ALL_SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Drug drug = new Drug(
                        rs.getInt("drug_id"),
                        rs.getString("drug_code"),
                        rs.getNString("drug_name"),
                        rs.getNString("active_ingredient"),
                        rs.getNString("unit"),
                        rs.getBoolean("is_active"),
                        rs.getTimestamp("create_at"));
                list.add(drug);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Drug getByID(int id) {
        try {
            PreparedStatement stm = c.prepareStatement(GET_BY_ID_SQL);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return new Drug(
                        rs.getInt("drug_id"),
                        rs.getString("drug_code"),
                        rs.getNString("drug_name"),
                        rs.getNString("active_ingredient"),
                        rs.getNString("unit"),
                        rs.getBoolean("is_active"),
                        rs.getTimestamp("create_at"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Drug getByCode(String code) {
        try {
            PreparedStatement stm = c.prepareStatement(GET_BY_ID_SQL);
            stm.setString(1, code);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return new Drug(rs.getInt("drug_id"),
                        rs.getString("drug_code"),
                        rs.getNString("drug_name"),
                        rs.getNString("active_ingredient"),
                        rs.getNString("unit"),
                        rs.getBoolean("is_active"),
                        rs.getTimestamp("create_at"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean add(Drug drug) {
        try {
            PreparedStatement stm = c.prepareStatement(ADD_SQL);
            stm.setString(1, drug.getDrug_code());
            stm.setString(2, drug.getDrug_name());
            stm.setString(2, drug.getActive_ingredient());
            stm.setString(3, drug.getUnit());
            stm.setBoolean(4, drug.isIs_active());

            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Drug drug) {
        try {
            PreparedStatement stm = c.prepareStatement(UPDATE_SQL);
            stm.setString(1, drug.getDrug_code());
            stm.setString(2, drug.getDrug_name());
            stm.setString(2, drug.getActive_ingredient());
            stm.setString(3, drug.getUnit());
            stm.setBoolean(4, drug.isIs_active());
            stm.setInt(5, drug.getDrug_id());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            PreparedStatement stm = c.prepareStatement(Delete_SQL);
            stm.setInt(1, id);
            int n = stm.executeUpdate();
            return n > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Drug> search(String keyword) {
        List<Drug> list = new ArrayList<>();

        try {
            PreparedStatement stm = c.prepareStatement(Search_SQL);
            String pattern = "%" + keyword + "%";
            stm.setString(1, pattern);
            stm.setString(2, pattern);
            stm.setString(3, pattern);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Drug drug = new Drug(
                        rs.getInt("drug_id"),
                        rs.getString("drug_code"),
                        rs.getNString("drug_name"),
                        rs.getNString("active_ingredient"),
                        rs.getNString("unit"),
                        rs.getBoolean("is_active"),
                        rs.getTimestamp("create_at"));
                list.add(drug);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        DrugDao dao = new DrugDao();
        System.out.println("=== TEST GET ALL ===");
        for (Drug d : dao.getAll()) {
            System.out.println(d.getDrug_id() + " - " + d.getDrug_name());
        }
    }
  
}
