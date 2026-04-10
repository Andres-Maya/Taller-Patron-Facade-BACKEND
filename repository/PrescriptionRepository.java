package com.clinical.system_medical.repository;

import com.clinical.system_medical.model.Prescription;

import java.util.List;

public interface PrescriptionRepository {
    Prescription save(Prescription prescription);

    List<Prescription> findByPatientId(String patientId);
}
