package com.example.batch2.demo.models;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;

public enum Designation {

    Buyer("1", "Buyer"),
    Seller("2", "Seller"),
    Poster("3", "Poster");


    private final String code;
    private final String customerType;

    // Constructor
    Designation(String code, String customerType) {
        this.code = code;
        this.customerType = customerType;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getCustomerType() {
        return customerType;
    }

    public static Designation getByCode(final String code) {
        return Arrays.stream(Designation.values())
                .filter(designation -> designation.getCode().equals(code))
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);
    }
}

