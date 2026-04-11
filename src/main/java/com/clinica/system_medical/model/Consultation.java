package com.clinical.system_medical.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Consultation {
    private final String id;
    private final String patientId;
    private final LocalDateTime dateTime;
    private final String symptoms;
    private final String diagnosis;
    private final String notes;

    public Consultation(
            String id,
            String patientId,
            LocalDateTime dateTime,
            String symptoms,
            String diagnosis,
            String notes
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.patientId = Objects.requireNonNull(patientId, "patientId is required");
        this.dateTime = Objects.requireNonNull(dateTime, "dateTime is required");
        this.symptoms = Objects.requireNonNullElse(symptoms, "");
        this.diagnosis = Objects.requireNonNullElse(diagnosis, "");
        this.notes = Objects.requireNonNullElse(notes, "");
    }

    public String getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getNotes() {
        return notes;
    }
}
