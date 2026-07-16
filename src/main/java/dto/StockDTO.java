package dto;

import java.sql.Date;

public class StockDTO {

    private int stockId;
    private int productId;
    private int stockIn;
    private int stockOut;
    private Date stockDate;
    private String remarks;
    private String productName;

    // Default Constructor
    public StockDTO() {

    }

    // Parameterized Constructor
    public StockDTO(int stockId, int productId, int stockIn,
            int stockOut, Date stockDate, String remarks,String productName) {
        this.stockId = stockId;
        this.productId = productId;
        this.stockIn = stockIn;
        this.stockOut = stockOut;
        this.stockDate = stockDate;
        this.remarks = remarks;
        this.productName=productName;
    }

    public int getStockId() {
        return stockId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStockIn() {
        return stockIn;
    }

    public void setStockIn(int stockIn) {
        this.stockIn = stockIn;
    }

    public int getStockOut() {
        return stockOut;
    }

    public void setStockOut(int stockOut) {
        this.stockOut = stockOut;
    }

    public Date getStockDate() {
        return stockDate;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
   
    public String toString() {
        return "StockDTO [stockId=" + stockId
                + ", productId=" + productId
                + ", productName=" + productName
                + ", stockIn=" + stockIn
                + ", stockOut=" + stockOut
                + ", stockDate=" + stockDate
                + ", remarks=" + remarks + "]";
    }
}