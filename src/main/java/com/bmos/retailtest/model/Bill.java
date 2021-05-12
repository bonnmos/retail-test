package com.bmos.retailtest.model;

public class Bill {
    private final String isGrocerl;
    private final String isEmployee;
    private final String isAffiliate;
    private final String isCustomerForOver2Years;

    public Bill(String isGrocerl, String isEmployee, String isAffiliate, String isCustomerForOver2Years) {
        this.isGrocerl = isGrocerl;
        this.isEmployee = isEmployee;
        this.isAffiliate = isAffiliate;
        this.isCustomerForOver2Years = isCustomerForOver2Years;
    }

    public String getIsGrocerl() {
        return isGrocerl;
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
}
