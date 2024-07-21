package com.home.assignment.utils;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.home.assignment.shared.AppConstants.TOTAL_PAGES;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class ServiceTestResource {

    protected static HttpHeaders getDefaultValidHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(TOTAL_PAGES, "1");
        return headers;
    }
}
