/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Supplier;

/**
 *
 * @author DELL
 */
public class SupplierDAO extends DBContext {

    private final String GET_ALL_SQL = "select *\n"
            + "from [dbo].[Suppliers] s\n"
            + "order by s.supplier_id desc  ";

    private final String GET_BY_ID_SQL = "select *\n"
            + "from Suppliers s \n"
            + "where s.supplier_id = ?";

    private final String ADD_SQL = "INSERT INTO [dbo].[Suppliers]\n"
            + "           ([supplier_name]\n"
            + "           ,[phone]\n"
            + "           ,[email]\n"
            + "           ,[address]\n"
            + "           ,[is_active])\n"
            + "     VALUES\n"
            + "           ?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?\n"
            + "           ,?";

    private final String UPDATE_SQL = "UPDATE Suppliers SET supplier_name = ?, phone = ?, email = ?, address = ?, is_active = ? WHERE supplier_id = ?";
    private final String DELETE_SQL = "DELETE FROM Suppliers WHERE supplier_id = ?";
    private final String SEARCH_SQL = "SELECT * FROM Suppliers WHERE supplier_name LIKE ? OR phone LIKE ? OR email LIKE ?";

    public List<Supplier> getAll() {
        List<Supplier> list = new ArrayList<>();

        try {
            PreparedStatement stm = c.prepareStatement(GET_ALL_SQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Supplier s = new Supplier(
                        rs.getInt("supplierId"),
                        rs.getString("suppliername"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getBoolean("is_active"));
                list.add(s);
            }

        } catch (Exception e) {
        }
        return list;
    }
    
    
    // đây là code để thêm các data mới vào database 
    public boolean add(Supplier supplier){
        try {
            // đầu tiên là tạo mơis 1 đối tưởng để chuẩn bị gửi câu lệnh cần thực thi cho SQL 
            // Pre (là biến obj để đưa data đi) stm(tên biến Ọbj mà ta đặt) = c(là biến mà nhận data và kết nối với DB). 
            PreparedStatement stm = c.prepareStatement(ADD_SQL);
            stm.setString(1, supplier.getSupplierName());
            stm.setString(2, supplier.getPhone());
            stm.setString(3, supplier.getEmail());
            stm.setString(4, supplier.getAddress());
            stm.setBoolean(5, supplier.isIsActive());
            
            int n = stm.executeUpdate(); // sau khi đưa data vào, thì đây là lệnh mà ta kêu rằng hãy thực thi và đưa data mới vào SQL 
            return n > 0; // nếu n = 1 thì là đúng vì n = 1 đồng nghĩa là có 1 data đc thêm thành công, thì vẫn okela 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean Update (Supplier supplier){
        try {
            PreparedStatement stm = c.prepareStatement(UPDATE_SQL);
            stm.setString(1, supplier.getSupplierName());
            stm.setString(2, supplier.getPhone());
            stm.setString(3, supplier.getEmail());
            stm.setString(4, supplier.getAddress());
            stm.setBoolean(5, supplier.isIsActive());
            
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
    
      public List<Supplier> search(String keyword) {
        List<Supplier> list = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SEARCH_SQL);
            String pattern = "%" + keyword + "%";
            stm.setString(1, pattern);
            stm.setString(2, pattern);
            stm.setString(3, pattern);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Supplier supplier = new Supplier(
                    rs.getInt("supplier_id"),
                    rs.getString("supplier_name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getBoolean("is_active")
                );
                list.add(supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
