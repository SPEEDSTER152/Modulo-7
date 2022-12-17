package Services;

import Interfaces.PatientRepository;
import entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

  @Autowired
  private PatientRepository patientRepository;

  public List<PatientRepository> findall(){
   return patientRepository.findAll();
  }

  public Patient findById(Long id){
      Optional<PatientRepository> patient = patientRepository.findById(id);
      if(Patient.isPresent()){
          return (Patient) patientRepository.findById(id).orElse(null);
      }
      return null;
  }

  public Patient post(Patient patient){
      return patientRepository.save(patient);
  }
  public Patient update(Patient patient){
    return patientRepository.save(patient);
  }

  public void delete(Long id){
      patientRepository.deleteById(id);
  }
}
