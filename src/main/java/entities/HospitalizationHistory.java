package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospitalization")
public class HospitalizationHistory {

@Id
private Long Id;

@ManyToOne(optional = false)
@JoinColumn(name = "patient_id", nullable = false)
private Patient patient;

@ManyToOne
@JoinColumn(name = "doctor_resp")
    private List<Doctor> doctor_resp = new ArrayList<>();
     private String dateEntry;
     private String dateExit;
     private String description;

    public HospitalizationHistory() {
    }

    public HospitalizationHistory(Long id, Patient patient, String dateEntry, String dateExit, String description) {
        this.Id = id;
        this.patient = patient;
        this.dateEntry = dateEntry;
        this.dateExit = dateExit;
        this.description = description;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Doctor> getDoctor_resp() {
        return doctor_resp;
    }

    public void setDoctor_resp(List<Doctor> doctor_resp) {
        this.doctor_resp = doctor_resp;
    }

    public String getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }

    public String getDateExit() {
        return dateExit;
    }

    public void setDateExit(String dateExit) {
        this.dateExit = dateExit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
