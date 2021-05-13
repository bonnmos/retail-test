package com.bmos.retailtest.api;

import com.bmos.retailtest.model.Bill;
import com.bmos.retailtest.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/retail")
@RestController
public class RetailTestController {

    private final BillService billService;

    @Autowired
    public RetailTestController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public String calculateNetPayable(@RequestBody Bill bill) {

        return billService.calculateNetPayable(bill);

    }
}
