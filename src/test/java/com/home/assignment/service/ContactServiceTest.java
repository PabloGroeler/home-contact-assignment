package com.home.assignment.service;

import com.home.assignment.client.ExternalApiClient;
import com.home.assignment.client.response.ContactResponse;
import com.home.assignment.client.response.ExternalContactResponse;
import com.home.assignment.model.Contact;
import com.home.assignment.stub.ExternalContactResponseStub;
import com.home.assignment.stub.ExternalContactStub;
import com.home.assignment.utils.ServiceTestResource;
import feign.FeignException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class ContactServiceTest extends ServiceTestResource {

    @InjectMocks
    ContactService contactService;

    @Mock
    ExternalApiClient externalApiClient;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService(externalApiClient, "token");
    }

    @Test
    void getContactSuccess() {
        ContactResponse contactResponseStub = ExternalContactStub.build();
        ExternalContactResponse externalContactResponseStub = ExternalContactResponseStub.build(contactResponseStub);

        HttpHeaders headers = getDefaultValidHttpHeaders();

        ResponseEntity<ExternalContactResponse> externalContactResponseResponseEntity =
                new ResponseEntity<>(externalContactResponseStub, headers, HttpStatus.OK);

        when(externalApiClient.getContacts(anyString(), anyInt())).thenReturn(externalContactResponseResponseEntity);

        List<Contact> contacts = contactService.getAllContacts();

        verify(externalApiClient, atLeastOnce()).getContacts(anyString(), anyInt());
        assert contacts.size() == 1;
        assert contacts.get(0).getName().equals(ExternalContactStub.TEST_NAME);
        assert contacts.get(0).getEmail().equals(ExternalContactStub.TEST_EMAIL);
    }
}
