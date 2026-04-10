package com.clinical.system_medical.model;

import java.util.Objects;

public class Doctor {
    private final String id;
    private final String fullName;
    private final Specialty specialty;

    public Doctor(String id, String fullName, Specialty specialty) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.fullName = Objects.requireNonNull(fullName, "fullName is required");
        this.specialty = Objects.requireNonNull(specialty, "specialty is required");
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Specialty getSpecialty() {
        return specialty;
    }
}
