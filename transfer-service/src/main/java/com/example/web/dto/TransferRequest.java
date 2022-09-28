package com.example.web.dto;

import org.hibernate.annotations.NotFound;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class TransferRequest {

    @Min(1)
    private double amount;
    @NotBlank
    private String source;
    @NotBlank
    private String destination;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
