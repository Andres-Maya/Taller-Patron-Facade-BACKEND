package com.clinical.system_medical.repository;

import com.clinical.system_medical.model.LabRequest;

import java.util.List;

public interface LaboratoryRepository {
    LabRequest save(LabRequest request);

    List<LabRequest> findByPatientId(String patientId);
}
