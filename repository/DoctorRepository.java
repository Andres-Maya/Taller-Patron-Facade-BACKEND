package com.clinical.system_medical.repository;

import com.clinical.system_medical.model.Doctor;
import com.clinical.system_medical.model.Specialty;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository {
    List<Doctor> findAll();

    List<Doctor> findBySpecialty(Specialty specialty);

    Optional<Doctor> findById(String id);
}
