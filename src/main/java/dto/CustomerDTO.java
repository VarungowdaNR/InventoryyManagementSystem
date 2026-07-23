package dto;

public class CustomerDTO {

    private int customerId;
    private String customerName;
    private String mobile;
    private String email;
    private String address;

  
    public CustomerDTO() {

    }

   
    public CustomerDTO(int customerId, String customerName,
            String mobile, String email, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
        return "CustomerDTO [customerId=" + customerId
                + ", customerName=" + customerName
                + ", mobile=" + mobile
                + ", email=" + email
                + ", address=" + address + "]";
    }
}