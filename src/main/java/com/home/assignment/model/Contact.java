package com.home.assignment.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
public class Contact {
    private int id;
    private String name;
    private String email;
    private String source;
    private Instant createdAt;
    private Instant updatedAt;
}
