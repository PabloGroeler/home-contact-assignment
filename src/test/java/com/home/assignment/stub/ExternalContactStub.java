package com.home.assignment.stub;

import com.home.assignment.client.response.ContactResponse;

import java.time.Instant;

public class ExternalContactStub {

    public static final String TEST_NAME = "Pablo Groeler";
    public static final String TEST_EMAIL = "pablo_groeler@kenect.com";

    public static ContactResponse build() {
        return ContactResponse.builder().id(1)
                .name(TEST_NAME)
                .email(TEST_EMAIL)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }
}
