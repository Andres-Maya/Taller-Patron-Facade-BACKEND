package com.clinical.system_medical.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {
    private final String id;
    private final String patientId;
    private final String doctorId;
    private final Specialty specialty;
    private final LocalDateTime dateTime;
    private AppointmentStatus status;

    public Appointment(
            String id,
            String patientId,
            String doctorId,
            Specialty specialty,
            LocalDateTime dateTime,
            AppointmentStatus status
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.patientId = Objects.requireNonNull(patientId, "patientId is required");
        this.doctorId = Objects.requireNonNull(doctorId, "doctorId is required");
        this.specialty = Objects.requireNonNull(specialty, "specialty is required");
        this.dateTime = Objects.requireNonNull(dateTime, "dateTime is required");
        this.status = Objects.requireNonNull(status, "status is required");
    }

    public String getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELED;
    }
}
