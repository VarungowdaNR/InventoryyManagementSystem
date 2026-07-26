package dto;

import java.sql.Timestamp;

public class UserDTO {

    private int userId;
    private String fullName;
    private String email;
    private String mobile;
    private String username;
    private String password;
    private String role;
    private Timestamp createdAt;

    
    public UserDTO() {

    }

    
    public UserDTO(int userId, String fullName, String email, String mobile,
                   String username, String password, String role,
                   Timestamp createdAt) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserDTO [userId=" + userId + ", fullName=" + fullName
                + ", email=" + email + ", mobile=" + mobile
                + ", username=" + username + ", password=" + password
                + ", role=" + role + ", createdAt=" + createdAt + "]";
    }
}