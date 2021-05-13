package com.bmos.retailtest.dao;

import com.bmos.retailtest.model.Bill;

public interface BillDao {

    double calculateNetPayable(Bill bill);
}
