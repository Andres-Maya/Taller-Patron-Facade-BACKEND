package com.clinical.system_medical.model;

import java.util.Objects;

public class LabResultEntry {
    private final String test;
    private final String parameter;
    private final double value;
    private final String unit;
    private final String referenceRange;

    public LabResultEntry(String test, String parameter, double value, String unit, String referenceRange) {
        this.test = Objects.requireNonNull(test, "test is required");
        this.parameter = Objects.requireNonNull(parameter, "parameter is required");
        this.value = value;
        this.unit = Objects.requireNonNull(unit, "unit is required");
        this.referenceRange = Objects.requireNonNull(referenceRange, "referenceRange is required");
    }

    public String getTest() {
        return test;
    }

    public String getParameter() {
        return parameter;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public String getReferenceRange() {
        return referenceRange;
    }
}
