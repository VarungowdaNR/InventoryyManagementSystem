package dao;

import java.util.List;

import dto.SupplierDTO;

public interface SupplierDAO {

    boolean addSupplier(SupplierDTO supplier);

    List<SupplierDTO> getAllSuppliers();

    SupplierDTO getSupplierById(int supplierId);

    boolean updateSupplier(SupplierDTO supplier);

    boolean deleteSupplier(int supplierId);

}