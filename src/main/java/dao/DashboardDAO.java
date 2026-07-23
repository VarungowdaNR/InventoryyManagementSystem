package dao;

public interface DashboardDAO {

    int getTotalProducts();

    int getTotalCategories();

    int getTotalSuppliers();

    int getTotalCustomers();

    int getAvailableStock();

    double getTotalSales();

}