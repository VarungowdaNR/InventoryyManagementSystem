package dto;

import java.sql.Timestamp;
import java.sql.Date;
public class ProductDTO {

    private int productId;
    private String productName;
    private int categoryId;
    private int supplierId;
    private double price;
    private int quantity;
    private String description;
    private Timestamp createdAt;
    private Date manufactureDate;
    private Date expiryDate;
    // For JOIN Queries
    private String categoryName;
    private String supplierName;

    // Default Constructor
    public ProductDTO() {

    }

    // Parameterized Constructor
    public ProductDTO(int productId, String productName, int categoryId,
            int supplierId, double price, int quantity,
            String description, Timestamp createdAt,
            String categoryName, String supplierName) {

        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.createdAt = createdAt;
        this.categoryName = categoryName;
        this.supplierName = supplierName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", categoryId=" + categoryId
				+ ", supplierId=" + supplierId + ", price=" + price + ", quantity=" + quantity + ", description="
				+ description + ", createdAt=" + createdAt + ", manufactureDate=" + manufactureDate + ", expiryDate="
				+ expiryDate + ", categoryName=" + categoryName + ", supplierName=" + supplierName + "]";
	}
    
    
}