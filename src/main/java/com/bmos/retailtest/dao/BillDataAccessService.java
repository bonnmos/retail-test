package com.bmos.retailtest.dao;

import com.bmos.retailtest.model.Bill;
import org.springframework.stereotype.Repository;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Repository("fakeDao")
public class BillDataAccessService implements BillDao {

    private double amount = 0.0;
    private double percentDiscountAmount = 0.0;
    private double hundredsDiscountAmount = 0.0;

    @Override
    public double calculateNetPayable(Bill bill) {

        // get the bill amount before any discount
        this.amount = bill.getAmount();

        this.hundredsDiscountAmount = getDiscountForEvery100(bill);

        if (bill.getIsGrocery().equals("no")) {
            this.percentDiscountAmount = getPercentageDiscount(bill);
        }

        var totalDiscount = this.hundredsDiscountAmount + this.percentDiscountAmount;
        System.out.println("total discount: " + totalDiscount);

        return this.amount - totalDiscount;
    }

    public double getPercentageDiscount(Bill bill) {
        System.out.println("inside the percentage discount method");

        var theDiscount = 0.0;

        if (bill.getIsEmployee().equals("yes"))
        {
            // give 30% discount
            theDiscount = 0.3 * amount;
            System.out.println("employee discount: " + theDiscount);
        }
        else if (bill.getIsAffiliate().equals("yes")) {
            // give 10% discount
            theDiscount = 0.1 * amount;
            System.out.println("affiliate discount: " + theDiscount);
        }
        else if (bill.getIsCustomerForOver2Years().equals("yes")) {
            // give 5% discount
            theDiscount = 0.05 * amount;
            System.out.println("over 2 years member discount: " + theDiscount);
        }

        return theDiscount;
    }

    public double getDiscountForEvery100(Bill bill) {
        var theDiscount = 0.0;
        var numHundreds = this.amount / 100;

        System.out.println("amount " + this.amount);

        if (numHundreds > 0) {
            DecimalFormat df = new DecimalFormat("#");
            df.setRoundingMode(RoundingMode.DOWN);
            theDiscount = 5 * Integer.valueOf(df.format(numHundreds));

            System.out.println("number of hundreds: " + Integer.valueOf(df.format(numHundreds)));
        }

        return theDiscount;
    }

}
