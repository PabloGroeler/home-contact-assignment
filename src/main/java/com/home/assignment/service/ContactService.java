package com.home.assignment.service;

import com.home.assignment.client.ExternalApiClient;
import com.home.assignment.client.response.ContactResponse;
import com.home.assignment.client.response.ExternalContactResponse;
import com.home.assignment.mapper.ContactMapper;
import com.home.assignment.model.Contact;
import com.home.assignment.shared.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Slf4j
@Service
public class ContactService {

    private final ExternalApiClient externalApiClient;
    private final String token;


    public ContactService(ExternalApiClient externalApiClient, @Value("${api.external.bearer.token}") String token) {
        this.externalApiClient = externalApiClient;
        this.token = token;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        int page = 1;
        int totalPages = 1;

        while (page <= totalPages) {
            ResponseEntity<ExternalContactResponse> responseEntity = externalApiClient.getContacts(token, page);

            List<ContactResponse> contactResponses = Optional.ofNullable(responseEntity)
                    .map(ResponseEntity::getBody)
                    .map(ExternalContactResponse::getContacts)
                    .orElse(Collections.emptyList());

            if (!CollectionUtils.isEmpty(contactResponses)) {
                contacts.addAll(contactResponses.stream().map(ContactMapper::fromExternalContact).toList());
            }

            totalPages = getTotalPages(totalPages, Objects.requireNonNull(responseEntity).getHeaders());
            page++;
        }


        return contacts;
    }

    private int getTotalPages(int totalPages, HttpHeaders headers) {
        String totalPagesHeader = headers.getFirst(AppConstants.TOTAL_PAGES);
        if (totalPagesHeader != null) {
            totalPages = Integer.parseInt(totalPagesHeader);
        }
        return totalPages;
    }

}
