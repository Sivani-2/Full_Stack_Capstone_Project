package model;

public class User {
    private int id;
    private String username;
    private String phoneNo;
    private String email;
    private String address;
    private String password;
    private String role;

    // No-argument constructor
    public User() {
    }

    // Constructor with parameters
    public User(String username, String phoneNo, String email, String address, String password, String role) {
        this.username = username;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
}