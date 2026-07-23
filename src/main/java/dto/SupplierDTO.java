package dto;

public class SupplierDTO {

    private int supplierId;
    private String supplierName;
    private String contactPerson;
    private String mobile;
    private String email;
    private String address;

    // Default Constructor
    public SupplierDTO() {

    }

    // Parameterized Constructor
    public SupplierDTO(int supplierId, String supplierName, String contactPerson,
                       String mobile, String email, String address) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.contactPerson = contactPerson;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SupplierDTO [supplierId=" + supplierId + ", supplierName=" + supplierName
                + ", contactPerson=" + contactPerson + ", mobile=" + mobile
                + ", email=" + email + ", address=" + address + "]";
    }
}