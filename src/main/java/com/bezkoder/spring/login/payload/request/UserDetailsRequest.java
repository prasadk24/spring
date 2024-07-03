package com.bezkoder.spring.login.payload.request;

import jakarta.validation.constraints.*;

public class UserDetailsRequest {

    @Size(max = 50)
    private String name;

    @Size(max = 255)
    private String address;

    @Size(max = 50)
    private String state;


    @Size(max = 30)
    private String country;

    @Size(max = 50)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message="Enter valid Email Id.")
    private String email;

    @Size(max = 10)
    private String pan;

    @Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
    private Long contactno;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public  Long getContactno() {
        return contactno;
    }

    public void setContactno(Long contactno) {
        this.contactno = contactno;
    }

}
