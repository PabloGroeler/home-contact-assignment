package com.home.assignment.stub;

import com.home.assignment.client.response.ContactResponse;
import com.home.assignment.client.response.ExternalContactResponse;

import java.util.Collections;

public class ExternalContactResponseStub {

    public static ExternalContactResponse build(ContactResponse contactResponse) {
        return ExternalContactResponse.builder()
                .contacts(Collections.singletonList(contactResponse))
                .build();
    }
}
