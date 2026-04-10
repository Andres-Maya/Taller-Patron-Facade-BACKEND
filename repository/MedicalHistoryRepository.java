package com.clinical.system_medical.repository;

import com.clinical.system_medical.model.MedicalHistory;

import java.util.Optional;

public interface MedicalHistoryRepository {
    MedicalHistory save(MedicalHistory history);

    Optional<MedicalHistory> findByPatientId(String patientId);
}
