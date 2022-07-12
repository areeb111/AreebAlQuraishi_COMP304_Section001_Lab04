package com.example.abhishekjamwal_comp304section001_labassignment4.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Customers {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private Integer custId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postalCode;


    public void setCustId(Integer custId) {this.custId = custId;}
    public Integer getCustId() {return custId;}
    public String getUserName() {return userName;}
    public String getPassword() {return password;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getAddress() {return address;}
    public String getCity() {return city;}
    public String getPostalCode() {return postalCode;}

    public void setUserName(String userName) { this.userName = userName; }
    public void setPassword(String password) { this.password = password; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    /*
    public Customers (String userName, String password, String firstName, String lastName, String address, String city, String postalCode) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }

     */
}
