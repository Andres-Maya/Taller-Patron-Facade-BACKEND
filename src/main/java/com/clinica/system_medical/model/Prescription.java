package com.clinical.system_medical.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Prescription {
    private final String id;
    private final String patientId;
    private final LocalDateTime issuedAt;
    private final List<PrescriptionItem> items;

    public Prescription(String id, String patientId, LocalDateTime issuedAt, List<PrescriptionItem> items) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.patientId = Objects.requireNonNull(patientId, "patientId is required");
        this.issuedAt = Objects.requireNonNull(issuedAt, "issuedAt is required");
        this.items = new ArrayList<>(items == null ? List.of() : items);
    }

    public String getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public List<PrescriptionItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
