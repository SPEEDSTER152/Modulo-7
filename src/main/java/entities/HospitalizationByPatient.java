package entities;

import Interfaces.HospitalizationHistoryRepository;

import java.util.List;

public class HospitalizationByPatient {
    private Patient patient;
    private List<HospitalizationHistoryRepository> hospitalizations;

    public HospitalizationByPatient(Patient patient, List<HospitalizationHistory> hospitalizations) {
        this.patient = patient;
        this.hospitalizations = hospitalizations;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<HospitalizationHistoryRepository> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<HospitalizationHistoryRepository> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }
}