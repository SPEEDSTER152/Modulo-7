package entities;

import Interfaces.HospitalizationHistoryRepository;

import java.util.List;

public class HospitalizationByDoctor {

    private Doctor doctor;
    private List<HospitalizationHistoryRepository>  Hopitalizations;

    public HospitalizationByDoctor(Doctor doctor, List<HospitalizationHistoryRepository> Hospitalizations) {
        this.doctor = doctor;
        this.Hopitalizations = Hospitalizations;
    }

    public List<HospitalizationHistoryRepository> getHopitalizations() {
        return Hopitalizations;
    }

    public void setHopitalizations(List<HospitalizationHistoryRepository> hopitalizations) {
        Hopitalizations = hopitalizations;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
