package com.bezkoder.spring.login.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bezkoder.spring.login.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private String username;
  @JsonIgnore
  private String password;

  private String address;
  private String state;
  private String country;


  private String email;
  private String pan;
  private Long contactno;
  private Date dob;
  private String accounttype;

  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(Long id, String name, String username, String password,
      String address, String state, String country, String email,
      String pan, Long contactno, Date dob, String accounttype,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
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
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getId(),
        user.getName(),
        user.getUsername(),
            user.getPassword(),
            user.getAddress(),
        user.getState(),
        user.getCountry(),
        user.getEmail(),
        user.getPan(),
        user.getContactno(),
        user.getDob(),
        user.getAccounttype(),
        authorities);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Long getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getAddress() {
    return address;
  }
  public String getState() {
    return state;
  }
  public String getCountry() {
    return country;
  }
  public String getEmail() {
    return email;
  }
  public String getPan() {
    return pan;
  }
  public Long getContactno() {
    return contactno;
  }
  public Date getDob() {
    return dob;
  }
  public String getAccounttype() {
    return accounttype;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
