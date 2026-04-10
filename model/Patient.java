package com.clinical.system_medical.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Patient {
    private final String id;
    private final String documentId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final LocalDate dateOfBirth;
    private final Set<String> allergies;

    public Patient(
            String id,
            String documentId,
            String firstName,
            String lastName,
            String email,
            String phone,
            LocalDate dateOfBirth,
            Set<String> allergies
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.documentId = Objects.requireNonNull(documentId, "documentId is required");
        this.firstName = Objects.requireNonNull(firstName, "firstName is required");
        this.lastName = Objects.requireNonNull(lastName, "lastName is required");
        this.email = Objects.requireNonNull(email, "email is required");
        this.phone = Objects.requireNonNull(phone, "phone is required");
        this.dateOfBirth = Objects.requireNonNull(dateOfBirth, "dateOfBirth is required");
        this.allergies = new HashSet<>(allergies == null ? Set.of() : allergies);
    }

    public String getId() {
        return id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Set<String> getAllergies() {
        return Collections.unmodifiableSet(allergies);
    }
}
