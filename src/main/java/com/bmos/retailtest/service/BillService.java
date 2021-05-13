package com.bmos.retailtest.service;

import com.bmos.retailtest.dao.BillDao;
import com.bmos.retailtest.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private final BillDao billDao;

    @Autowired
    public BillService(@Qualifier("fakeDao") BillDao billDao) {
        this.billDao = billDao;
    }

    public String calculateNetPayable(Bill bill) {
        return "Amount payable is $" + billDao.calculateNetPayable(bill);
    }
}
