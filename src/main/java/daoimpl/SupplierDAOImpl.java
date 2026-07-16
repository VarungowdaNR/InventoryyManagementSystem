package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SupplierDAO;
import database.DBConnection;
import dto.SupplierDTO;

public class SupplierDAOImpl implements SupplierDAO {

    private Connection con = DBConnection.getConnection();

    @Override
    public boolean addSupplier(SupplierDTO supplier) {

        String query = "INSERT INTO supplier(supplier_name,contact_person,mobile,email,address) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getContactPerson());
            ps.setString(3, supplier.getMobile());
            ps.setString(4, supplier.getEmail());
            ps.setString(5, supplier.getAddress());

            int result = ps.executeUpdate();

            if(result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {

        List<SupplierDTO> list = new ArrayList<SupplierDTO>();

        String query = "SELECT * FROM supplier";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                SupplierDTO supplier = new SupplierDTO();

                supplier.setSupplierId(rs.getInt("supplier_id"));
                supplier.setSupplierName(rs.getString("supplier_name"));
                supplier.setContactPerson(rs.getString("contact_person"));
                supplier.setMobile(rs.getString("mobile"));
                supplier.setEmail(rs.getString("email"));
                supplier.setAddress(rs.getString("address"));

                list.add(supplier);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public SupplierDTO getSupplierById(int supplierId) {

        String query = "SELECT * FROM supplier WHERE supplier_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, supplierId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                SupplierDTO supplier = new SupplierDTO();

                supplier.setSupplierId(rs.getInt("supplier_id"));
                supplier.setSupplierName(rs.getString("supplier_name"));
                supplier.setContactPerson(rs.getString("contact_person"));
                supplier.setMobile(rs.getString("mobile"));
                supplier.setEmail(rs.getString("email"));
                supplier.setAddress(rs.getString("address"));

                return supplier;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) {

        String query = "UPDATE supplier SET supplier_name=?,contact_person=?,mobile=?,email=?,address=? WHERE supplier_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getContactPerson());
            ps.setString(3, supplier.getMobile());
            ps.setString(4, supplier.getEmail());
            ps.setString(5, supplier.getAddress());
            ps.setInt(6, supplier.getSupplierId());

            int result = ps.executeUpdate();

            if(result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteSupplier(int supplierId) {

        String query = "DELETE FROM supplier WHERE supplier_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, supplierId);

            int result = ps.executeUpdate();

            if(result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}