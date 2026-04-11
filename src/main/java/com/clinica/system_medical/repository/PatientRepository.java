package com.clinical.system_medical.repository;

import com.clinical.system_medical.model.Patient;

import java.util.Optional;

public interface PatientRepository {
    Patient save(Patient patient);

    Optional<Patient> findById(String id);

    Optional<Patient> findByDocumentId(String documentId);
}
