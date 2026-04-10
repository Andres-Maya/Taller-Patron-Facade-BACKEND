package com.clinical.system_medical.repository.memory;

import com.clinical.system_medical.model.LabRequest;
import com.clinical.system_medical.repository.LaboratoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class InMemoryLaboratoryRepository implements LaboratoryRepository {
    private final Map<String, List<LabRequest>> requestsByPatientId = new ConcurrentHashMap<>();

    @Override
    public LabRequest save(LabRequest request) {
        requestsByPatientId
                .computeIfAbsent(request.getPatientId(), ignored -> new CopyOnWriteArrayList<>())
                .add(request);
        return request;
    }

    @Override
    public List<LabRequest> findByPatientId(String patientId) {
        return requestsByPatientId.getOrDefault(patientId, List.of());
    }
}
