package com.bezkoder.spring.login.payload.request;

import java.util.Date;
import java.util.Set;

public class LoanRequest {

    private long id;
    private String loanType;
    private int loanAmount;
    private Date loanDate;
    private int rateOfInterest;
    private String durationOfLoan;
    private long userId;

    public LoanRequest(long id, String loanType, int loanAmount, Date loanDate, int rateOfInterest, String durationOfLoan, long userId) {
        this.id = id;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.loanDate = loanDate;
        this.rateOfInterest = rateOfInterest;
        this.durationOfLoan = durationOfLoan;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public int getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(int rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getDurationOfLoan() {
        return durationOfLoan;
    }

    public void setDurationOfLoan(String durationOfLoan) {
        this.durationOfLoan = durationOfLoan;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
