package Adapters;

import Interfaces.PatientRepository;
import entities.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalizationAdapter {

  public  List<HospitalizationByPatient> adaptHospitalizationByPacient(
          List<HospitalizationHistory> hospitalizations,
          List<PatientRepository> patients){
        List<HospitalizationByPatient> hospitalizationByPatients = patients.stream()
                .map(patient -> {
                   List<HospitalizationHistory> hospitalizationsByPatient = hospitalizations.stream()
                           .filter(history->history.getPatient().getId())
                           .equals(patient.getId())
                           .collect(Collectors.toList());
                   return new HospitalizationByPatient((Patient) patient,hospitalizationsByPatient);
                }).collect(Collectors.toList());
        return hospitalizationByPatients;
  }
  public List<HospitalizationByDoctor> adaptHospitalizationByDoctor(
          List<HospitalizationHistory> hospitalizations,
          List<PatientRepository> doctors){
      List<HospitalizationByDoctor> hospitalizationByDoctors = doctors.stream()
              .map(doctor -> {
                  List<HospitalizationHistory> hospitalizationsByDoctor = hospitalizations.stream()
                          .filter(history->history.getPatient().getId())
                          .equals(doctor.getId())
                          .collect(Collectors.toList());
                  return new HospitalizationByDoctor(doctor,HospitalizationHistoryList);
              }).collect(Collectors.toList());
      return hospitalizationByDoctors;
  }
}
