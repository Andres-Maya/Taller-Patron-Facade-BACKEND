package com.clinical.system_medical.repository.memory;

import com.clinical.system_medical.model.Doctor;
import com.clinical.system_medical.model.Specialty;
import com.clinical.system_medical.repository.DoctorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryDoctorRepository implements DoctorRepository {
    private final Map<String, Doctor> doctorsById = new ConcurrentHashMap<>();

    public InMemoryDoctorRepository() {
        seedDoctors();
    }

    private void seedDoctors() {
        saveInternal(new Doctor("D-1001", "Dr. Amanda Smith", Specialty.GENERAL_MEDICINE));
        saveInternal(new Doctor("D-1002", "Dr. Carlos Ramirez", Specialty.PEDIATRICS));
        saveInternal(new Doctor("D-1003", "Dr. Sofia Johnson", Specialty.DERMATOLOGY));
        saveInternal(new Doctor("D-1004", "Dr. Daniel Lee", Specialty.GENERAL_MEDICINE));
        saveInternal(new Doctor("D-1005", "Dr. Valentina Gomez", Specialty.PEDIATRICS));
    }

    private void saveInternal(Doctor doctor) {
        doctorsById.put(doctor.getId(), doctor);
    }

    @Override
    public List<Doctor> findAll() {
        return new ArrayList<>(doctorsById.values());
    }

    @Override
    public List<Doctor> findBySpecialty(Specialty specialty) {
        return doctorsById.values().stream()
                .filter(d -> d.getSpecialty() == specialty)
                .toList();
    }

    @Override
    public Optional<Doctor> findById(String id) {
        return Optional.ofNullable(doctorsById.get(id));
    }
}
