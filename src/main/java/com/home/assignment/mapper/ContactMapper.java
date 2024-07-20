package com.home.assignment.mapper;

import com.home.assignment.model.Contact;
import com.home.assignment.client.response.ContactResponse;
import com.home.assignment.shared.AppConstants;

public class ContactMapper {

    public static Contact fromExternalContact(ContactResponse contactResponse) {
        return Contact.builder()
                .id(contactResponse.getId())
                .name(contactResponse.getName())
                .email(contactResponse.getEmail())
                .source(AppConstants.DEFAULT_SOURCE)
                .createdAt(contactResponse.getCreatedAt())
                .updatedAt(contactResponse.getUpdatedAt())
                .build();
    }
}
