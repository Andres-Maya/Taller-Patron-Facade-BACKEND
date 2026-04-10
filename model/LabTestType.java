package com.clinical.system_medical.model;

import java.util.Locale;

public enum LabTestType {
    HEMOGRAM,
    GLUCOSE,
    LIPID_PROFILE;

    public static LabTestType fromString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Lab test type is required");
        }
        String normalized = value.trim().toUpperCase(Locale.ROOT).replace(' ', '_');
        return LabTestType.valueOf(normalized);
    }
}
