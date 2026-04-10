package com.clinical.system_medical.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MedicalHistory {
    private final String patientId;
    private final Set<String> allergies;
    private final List<String> diagnoses;
    private final List<Consultation> consultations;

    public MedicalHistory(String patientId, Set<String> allergies, List<String> diagnoses, List<Consultation> consultations) {
        this.patientId = Objects.requireNonNull(patientId, "patientId is required");
        this.allergies = new HashSet<>(allergies == null ? Set.of() : allergies);
        this.diagnoses = new ArrayList<>(diagnoses == null ? List.of() : diagnoses);
        this.consultations = new ArrayList<>(consultations == null ? List.of() : consultations);
    }

    public String getPatientId() {
        return patientId;
    }

    public Set<String> getAllergies() {
        return Collections.unmodifiableSet(allergies);
    }

    public List<String> getDiagnoses() {
        return Collections.unmodifiableList(diagnoses);
    }

    public List<Consultation> getConsultations() {
        return Collections.unmodifiableList(consultations);
    }

    public void addAllergy(String allergy) {
        if (allergy == null || allergy.isBlank()) {
            return;
        }
        allergies.add(allergy.trim());
    }

    public void addDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.isBlank()) {
            return;
        }
        diagnoses.add(diagnosis.trim());
    }

    public void addConsultation(Consultation consultation) {
        consultations.add(Objects.requireNonNull(consultation, "consultation is required"));
        if (!consultation.getDiagnosis().isBlank()) {
            addDiagnosis(consultation.getDiagnosis());
        }
    }
}
