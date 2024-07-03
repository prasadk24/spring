package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Loan;
import com.bezkoder.spring.login.payload.request.LoanRequest;
import com.bezkoder.spring.login.payload.request.UserDetailsRequest;
import com.bezkoder.spring.login.repository.LoanRepository;
import com.bezkoder.spring.login.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.bezkoder.spring.login.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @Autowired
  UserRepository userRepository;

  @Autowired
  LoanRepository loanRepository;

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }

  @GetMapping("/user/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Optional<User> getUserData(@PathVariable Long id) {
    Optional<User> user = userRepository.findById(id);
    return user;
  }

  @PutMapping("/updateuser/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public String UserDetailsUpdate(@Valid @RequestBody UserDetailsRequest userDetailsRequest,
                                  @PathVariable Long id) {

    if( userDetailsRequest.getName() != null &&
            userDetailsRequest.getAddress() != null &&
            userDetailsRequest.getState() != null &&
            userDetailsRequest.getCountry() != null &&
            userDetailsRequest.getEmail() != null &&
            userDetailsRequest.getPan() != null &&
            userDetailsRequest.getContactno() != null
    ) {
      userRepository.updateUser(id,
              userDetailsRequest.getName(),
              userDetailsRequest.getAddress(),
              userDetailsRequest.getState(),
              userDetailsRequest.getCountry(),
              userDetailsRequest.getEmail(),
              userDetailsRequest.getPan(),
              userDetailsRequest.getContactno());
      return "Success";
    } else {
      return "failure";
    }
  }





  @GetMapping("/loan/{id}")
  public Optional<Loan> getUserLoanData(@PathVariable Long id) {
    Optional<Loan> loan = loanRepository.findById(id);
    return loan;
  }

  @PostMapping("/loan")
  public ResponseEntity<?> registerLoan(@Valid @RequestBody LoanRequest loanRequest) {

    Loan loan = new Loan(loa
            loanRequest.getId(),
            loanRequest.getLoanType(),
            loanRequest.getLoanAmount(),
            loanRequest.getLoanDate(),
            loanRequest.getRateOfInterest(),
            loanRequest.getDurationOfLoan(),
            loanRequest.getUserId()
    );
    loanRepository.save(loan);
    return ResponseEntity.ok().body("Loan created");
  }
}
