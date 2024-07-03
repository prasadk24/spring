package com.bezkoder.spring.login.payload.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

public class SignupRequest {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Size(max = 255)
    private String address;

    @NotBlank
    @Size(max = 50)
    private String state;

    @NotBlank
    @Size(max = 30)
    private String country;

    @NotBlank
    @Size(max = 50)
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message="Enter valid Email Id.")
    private String email;

    @NotBlank
    @Size(max = 10)
    private String pan;

    @NotNull
    @Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
    private Long contactno;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Enter valid date.")
    private Date dob;

    @NotBlank
    private String accounttype;

    private Set<String> role;

    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    


    public @NotBlank @Size(max = 50) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(max = 50) String name) {
        this.name = name;
    }

    public @NotBlank @Size(max = 255) String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank @Size(max = 255) String address) {
        this.address = address;
    }

    public @NotBlank @Size(max = 50) String getState() {
        return state;
    }

    public void setState(@NotBlank @Size(max = 50) String state) {
        this.state = state;
    }

    public @NotBlank @Size(max = 30) String getCountry() {
        return country;
    }

    public void setCountry(@NotBlank @Size(max = 30) String country) {
        this.country = country;
    }

    public @NotBlank @Size(max = 10) String getPan() {
        return pan;
    }

    public void setPan(@NotBlank @Size(max = 10) String pan) {
        this.pan = pan;
    }

    public  Long getContactno() {
        return contactno;
    }

    public void setContactno(Long contactno) {
        this.contactno = contactno;
    }

    public  Date getDob() {
        return dob;
    }

    public void setDob(String dob) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dob = sdf.parse(dob);
    }

    public @NotBlank String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(@NotBlank String accounttype) {
        this.accounttype = accounttype;
    }
    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
