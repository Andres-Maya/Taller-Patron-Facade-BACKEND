package com.clinical.system_medical.repository.memory;

import com.clinical.system_medical.model.Appointment;
import com.clinical.system_medical.model.AppointmentStatus;
import com.clinical.system_medical.repository.AppointmentRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryAppointmentRepository implements AppointmentRepository {
    private final Map<String, Appointment> appointmentsById = new ConcurrentHashMap<>();

    @Override
    public Appointment save(Appointment appointment) {
        appointmentsById.put(appointment.getId(), appointment);
        return appointment;
    }

    @Override
    public Optional<Appointment> findById(String id) {
        return Optional.ofNullable(appointmentsById.get(id));
    }

    @Override
    public boolean existsByDoctorAndDateTime(String doctorId, LocalDateTime dateTime) {
        return appointmentsById.values().stream()
                .anyMatch(a -> a.getDoctorId().equals(doctorId)
                        && a.getDateTime().equals(dateTime)
                        && a.getStatus() == AppointmentStatus.SCHEDULED);
    }

    @Override
    public List<Appointment> findByPatientId(String patientId) {
        return appointmentsById.values().stream()
                .filter(a -> a.getPatientId().equals(patientId))
                .toList();
    }
}
