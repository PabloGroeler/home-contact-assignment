package com.home.assignment.controller;

import com.home.assignment.model.Contact;
import com.home.assignment.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Contacts")
@RequestMapping("/api/v1/contacts")
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    @Operation(
            summary = "Searches for articles based on the filters provided.",
            description = "Searches on all available articles based on the filters provided in a paginated response with maximum of 5 articles per request.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Contact[].class))),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            }
    )
    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }
}
