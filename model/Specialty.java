package com.clinical.system_medical.model;

import java.util.Locale;

public enum Specialty {
    GENERAL_MEDICINE,
    PEDIATRICS,
    DERMATOLOGY;

    public static Specialty fromString(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Specialty is required");
        }
        String normalized = value.trim().toUpperCase(Locale.ROOT).replace(' ', '_');
        return Specialty.valueOf(normalized);
    }
}
