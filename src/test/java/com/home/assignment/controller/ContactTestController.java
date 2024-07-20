package com.home.assignment.controller;

import com.home.assignment.utils.TestControllerResource;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ContactTestController extends TestControllerResource {

    @Test
    void getContacts() throws Exception {
        this.mockedMvc.perform(get("/api/v1/contacts"))
                .andExpect(status().isOk());

    }
}