package com.clinical.system_medical.repository.memory;

import com.clinical.system_medical.model.Patient;
import com.clinical.system_medical.repository.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryPatientRepository implements PatientRepository {
    private final Map<String, Patient> patientsById = new ConcurrentHashMap<>();
    private final Map<String, String> patientIdByDocumentId = new ConcurrentHashMap<>();

    @Override
    public synchronized Patient save(Patient patient) {
        patientsById.put(patient.getId(), patient);
        patientIdByDocumentId.put(patient.getDocumentId(), patient.getId());
        return patient;
    }

    @Override
    public Optional<Patient> findById(String id) {
        return Optional.ofNullable(patientsById.get(id));
    }

    @Override
    public Optional<Patient> findByDocumentId(String documentId) {
        String patientId = patientIdByDocumentId.get(documentId);
        if (patientId == null) {
            return Optional.empty();
        }
        return findById(patientId);
    }
}
