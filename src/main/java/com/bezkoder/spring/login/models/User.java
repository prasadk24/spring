package com.bezkoder.spring.login.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       })
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 50)
  private String name;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 120)
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
  @Email
  private String email;

  @NotBlank
  @Size(max = 10)
  private String pan;

  @NotNull
  private Long contactno;

  @NotNull
  private Date dob;

  @NotBlank
  @Size(max = 15)
  private String accounttype;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles", 
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))

  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String name, String username, String password, String address, String state, String country, String email, String pan, Long contactno, Date dob, String accounttype) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.address = address;
    this.state = state;
    this.country = country;
    this.email = email;
    this.pan = pan;
    this.contactno = contactno;
    this.dob = dob;
    this.accounttype = accounttype;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPan() {
    return pan;
  }

  public void setPan(String pan) {
    this.pan = pan;
  }

  public Long getContactno() {
    return contactno;
  }

  public void setContactno(Long contactno) {
    this.contactno = contactno;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public String getAccounttype() {
    return accounttype;
  }

  public void setAccounttype(String accounttype) {
    this.accounttype = accounttype;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
