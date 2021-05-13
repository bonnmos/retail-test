package com.bmos.retailtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RetailTestApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void testPercentageDiscountNotOfferedIfItsGroceryAndUserIsEmployee() throws Exception {
        Object randomObj = new Object() {
            public final String isGrocery = "yes";
            public final String  isEmployee = "yes";
            public final String  isAffiliate = "no";
            public final String isCustomerForOver2Years = "no";
            public final double amount = 190.0;
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);

        mvc.perform(MockMvcRequestBuilders.post("/api/retail")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Amount payable is $185.0")));
    }

    @Test
    void testPercentageDiscountOfferedIfItsNotGroceryAndUserIsEmployee() throws Exception {
        Object randomObj = new Object() {
            public final String isGrocery = "no";
            public final String  isEmployee = "yes";
            public final String  isAffiliate = "no";
            public final String isCustomerForOver2Years = "no";
            public final double amount = 190.0;
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);

        mvc.perform(MockMvcRequestBuilders.post("/api/retail")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Amount payable is $128.0")));
    }

    @Test
    void testPercentageDiscountOfferedIfItsNotGroceryAndUserIsAffiliate() throws Exception {
        Object randomObj = new Object() {
            public final String isGrocery = "no";
            public final String  isEmployee = "no";
            public final String  isAffiliate = "Yes";
            public final String isCustomerForOver2Years = "no";
            public final double amount = 190.0;
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);

        mvc.perform(MockMvcRequestBuilders.post("/api/retail")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Amount payable is $166.0")));
    }

    @Test
    void testPercentageDiscountOfferedIfItsNotGroceryAndUserIsMemberForMoreThan2Years() throws Exception {
        Object randomObj = new Object() {
            public final String isGrocery = "no";
            public final String  isEmployee = "no";
            public final String  isAffiliate = "no";
            public final String isCustomerForOver2Years = "yes";
            public final double amount = 190.0;
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(randomObj);

        mvc.perform(MockMvcRequestBuilders.post("/api/retail")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Amount payable is $175.5")));
    }

}
