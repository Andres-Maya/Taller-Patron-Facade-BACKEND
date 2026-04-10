package com.clinical.system_medical.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LabRequest {
    private final String id;
    private final String patientId;
    private final LocalDateTime requestedAt;
    private final List<LabTestType> tests;
    private final List<LabResultEntry> results;

    public LabRequest(
            String id,
            String patientId,
            LocalDateTime requestedAt,
            List<LabTestType> tests,
            List<LabResultEntry> results
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.patientId = Objects.requireNonNull(patientId, "patientId is required");
        this.requestedAt = Objects.requireNonNull(requestedAt, "requestedAt is required");
        this.tests = new ArrayList<>(tests == null ? List.of() : tests);
        this.results = new ArrayList<>(results == null ? List.of() : results);
    }

    public String getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public List<LabTestType> getTests() {
        return Collections.unmodifiableList(tests);
    }

    public List<LabResultEntry> getResults() {
        return Collections.unmodifiableList(results);
    }
}
