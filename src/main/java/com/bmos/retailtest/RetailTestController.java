package com.bmos.retailtest;

import org.springframework.web.bind.annotation.*;

@RestController
public class RetailTestController {

    @GetMapping("/api/retail")
    @ResponseBody
    public String index(@RequestParam String isGrocery) {
        if (isGrocery.equals("yes")) {
            return "it is grocery";
        }

        return "not grocery";
    }
}
