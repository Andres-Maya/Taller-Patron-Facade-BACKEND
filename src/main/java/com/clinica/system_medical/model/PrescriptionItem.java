package com.clinical.system_medical.model;

import java.util.Objects;

public class PrescriptionItem {
    private final String medication;
    private final String dosage;
    private final int durationDays;

    public PrescriptionItem(String medication, String dosage, int durationDays) {
        this.medication = Objects.requireNonNull(medication, "medication is required");
        this.dosage = Objects.requireNonNull(dosage, "dosage is required");
        this.durationDays = durationDays;
    }

    public String getMedication() {
        return medication;
    }

    public String getDosage() {
        return dosage;
    }

    public int getDurationDays() {
        return durationDays;
    }
}
