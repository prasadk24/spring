package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findById(Long id);
}
