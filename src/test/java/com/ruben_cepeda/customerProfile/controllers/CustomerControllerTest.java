package com.ruben_cepeda.customerProfile.controllers;

import com.ruben_cepeda.customerProfile.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;

//    @Test
    public void createCustomer() throws Exception {
        final Customer customer = new Customer("Ruben", "Cepeda", "ruben.cepeda@gmail.com");

    }
}