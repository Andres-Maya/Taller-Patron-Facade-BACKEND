package com.clinical.system_medical.config;

import com.clinical.system_medical.dto.request.MedicationRequest;
import com.clinical.system_medical.model.LabTestType;
import com.clinical.system_medical.model.Patient;
import com.clinical.system_medical.repository.PatientRepository;
import com.clinical.system_medical.service.LaboratoryService;
import com.clinical.system_medical.service.MedicalHistoryService;
import com.clinical.system_medical.service.PrescriptionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {
    public static final String DEMO_PATIENT_ID = "11111111-1111-1111-1111-111111111111";

    private final PatientRepository patientRepository;
    private final MedicalHistoryService medicalHistoryService;
    private final PrescriptionService prescriptionService;
    private final LaboratoryService laboratoryService;

    public DataSeeder(
            PatientRepository patientRepository,
            MedicalHistoryService medicalHistoryService,
            PrescriptionService prescriptionService,
            LaboratoryService laboratoryService
    ) {
        this.patientRepository = patientRepository;
        this.medicalHistoryService = medicalHistoryService;
        this.prescriptionService = prescriptionService;
        this.laboratoryService = laboratoryService;
    }

    @Override
    public void run(String... args) {
        patientRepository.findById(DEMO_PATIENT_ID).ifPresentOrElse(
                ignored -> {
                },
                this::seedDemoPatient
        );
    }

    private void seedDemoPatient() {
        Patient demo = new Patient(
                DEMO_PATIENT_ID,
                "CC-10000001",
                "Maria",
                "Gonzalez",
                "maria.gonzalez@example.com",
                "+57-300-000-0000",
                LocalDate.of(1992, 5, 12),
                Set.of("penicillin")
        );
        patientRepository.save(demo);

        medicalHistoryService.initializeIfAbsent(DEMO_PATIENT_ID, demo.getAllergies());
        medicalHistoryService.addConsultation(DEMO_PATIENT_ID, "Headache and fatigue", "Tension headache", "Recommended hydration and rest");

        prescriptionService.generate(DEMO_PATIENT_ID, List.of(
                new MedicationRequest("Ibuprofen", "400mg every 8 hours", 3)
        ));

        laboratoryService.requestTests(DEMO_PATIENT_ID, List.of(LabTestType.HEMOGRAM, LabTestType.GLUCOSE, LabTestType.LIPID_PROFILE));
    }
}
