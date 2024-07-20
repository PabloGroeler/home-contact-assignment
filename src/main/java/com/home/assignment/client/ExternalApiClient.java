package com.home.assignment.client;

import com.home.assignment.client.response.ExternalContactResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "externalApi", url = "https://k-messages-api.herokuapp.com/api/v1")
public interface ExternalApiClient {
    @GetMapping("/contacts")
    ResponseEntity<ExternalContactResponse> getContacts(@RequestHeader("Authorization") String authorization,
                                                       @RequestParam(value = "page", required = false) Integer page);
}