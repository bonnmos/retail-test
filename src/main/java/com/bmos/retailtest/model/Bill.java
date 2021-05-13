package com.bmos.retailtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bill {
    private final String isGrocery;
    private final String isEmployee;
    private final String isAffiliate;
    private final String isCustomerForOver2Years;
    private double amount;
    private double amountAfterDiscount;

    public Bill(@JsonProperty("isGrocery") String isGrocery,
                @JsonProperty("isEmployee") String isEmployee,
                @JsonProperty("isAffiliate") String isAffiliate,
                @JsonProperty("isCustomerForOver2Years") String isCustomerForOver2Years,
                @JsonProperty("amount") double amount) {
        this.isGrocery = isGrocery;
        this.isEmployee = isEmployee;
        this.isAffiliate = isAffiliate;
        this.isCustomerForOver2Years = isCustomerForOver2Years;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getIsGrocery() {
        return isGrocery;
    }

    public String getIsEmployee() {
        return isEmployee;
    }

    public String getIsAffiliate() {
        return isAffiliate;
    }

    public String getIsCustomerForOver2Years() {
        return isCustomerForOver2Years;
    }

    public double getAmountAfterDiscount() {
        return amountAfterDiscount;
    }

    public void setAmountAfterDiscount(double amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }
}
