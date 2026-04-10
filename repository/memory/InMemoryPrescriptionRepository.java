package com.clinical.system_medical.repository.memory;

import com.clinical.system_medical.model.Prescription;
import com.clinical.system_medical.repository.PrescriptionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class InMemoryPrescriptionRepository implements PrescriptionRepository {
    private final Map<String, List<Prescription>> prescriptionsByPatientId = new ConcurrentHashMap<>();

    @Override
    public Prescription save(Prescription prescription) {
        prescriptionsByPatientId
                .computeIfAbsent(prescription.getPatientId(), ignored -> new CopyOnWriteArrayList<>())
                .add(prescription);
        return prescription;
    }

    @Override
    public List<Prescription> findByPatientId(String patientId) {
        return prescriptionsByPatientId.getOrDefault(patientId, List.of());
    }
}
