package dto;

import java.sql.Timestamp;

public class SalesDTO {

    private int saleId;
    private int customerId;
    private double totalAmount;
    private Timestamp saleDate;

    // Default Constructor
    public SalesDTO() {

    }

    // Parameterized Constructor
    public SalesDTO(int saleId,
            int customerId,
            double totalAmount,
            Timestamp saleDate) {

        this.saleId = saleId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.saleDate = saleDate;

    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {

        return "SalesDTO [saleId=" + saleId
                + ", customerId=" + customerId
                + ", totalAmount=" + totalAmount
                + ", saleDate=" + saleDate + "]";

    }

}