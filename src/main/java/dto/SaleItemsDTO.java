package dto;

public class SaleItemsDTO {

    private int saleItemId;
    private int saleId;
    private int productId;
    private int quantity;
    private double price;
    private double subtotal;

    // Default Constructor
    public SaleItemsDTO() {

    }

    // Parameterized Constructor
    public SaleItemsDTO(
            int saleItemId,
            int saleId,
            int productId,
            int quantity,
            double price,
            double subtotal) {

        this.saleItemId = saleItemId;
        this.saleId = saleId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;

    }

    public int getSaleItemId() {
        return saleItemId;
    }

    public void setSaleItemId(int saleItemId) {
        this.saleItemId = saleItemId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {

        return "SaleItemsDTO [saleItemId="
                + saleItemId
                + ", saleId=" + saleId
                + ", productId=" + productId
                + ", quantity=" + quantity
                + ", price=" + price
                + ", subtotal=" + subtotal
                + "]";

    }

}