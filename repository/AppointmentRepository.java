package com.clinical.system_medical.repository;

import com.clinical.system_medical.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
    Appointment save(Appointment appointment);

    Optional<Appointment> findById(String id);

    boolean existsByDoctorAndDateTime(String doctorId, LocalDateTime dateTime);

    List<Appointment> findByPatientId(String patientId);
}
