package com.clinical.system_medical.repository.memory;

import com.clinical.system_medical.model.MedicalHistory;
import com.clinical.system_medical.repository.MedicalHistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryMedicalHistoryRepository implements MedicalHistoryRepository {
    private final Map<String, MedicalHistory> historyByPatientId = new ConcurrentHashMap<>();

    @Override
    public MedicalHistory save(MedicalHistory history) {
        historyByPatientId.put(history.getPatientId(), history);
        return history;
    }

    @Override
    public Optional<MedicalHistory> findByPatientId(String patientId) {
        return Optional.ofNullable(historyByPatientId.get(patientId));
    }
}
