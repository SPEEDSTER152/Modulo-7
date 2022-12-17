package Controller;

import Adapters.HospitalizationAdapter;
import Interfaces.DoctorRepository;
import Interfaces.PatientRepository;
import Services.DoctorService;
import Services.HospitalizationHistoryService;
import Services.PatientService;
import entities.HospitalizationByDoctor;
import entities.HospitalizationByPatient;
import entities.HospitalizationHistory;
import entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class HospitalizationHistoryController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private HospitalizationHistoryService hospitalizationHistoryService;

    @Autowired
    private HospitalizationAdapter hospitalizationAdapter;

    @GetMapping
    public ResponseEntity<List<HospitalizationHistory>> findall(){
        return new ResponseEntity<>(hospitalizationHistoryService.findall(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<List<HospitalizationHistory>> findById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(hospitalizationHistoryService.findall(),HttpStatus.OK);
    }

    @GetMapping("by-patients")
    public ResponseEntity<List<HospitalizationByPatient>> hospitalizationByPatient(){
        List<PatientRepository> patients = patientService.findall();
          List<HospitalizationHistory> hospitalizationHistories = hospitalizationHistoryService.findall();
          List<HospitalizationByPatient> hospitalizationByPatients =
           hospitalizationAdapter.adaptHospitalizationByPacient(hospitalizationHistories, patients);

          return new ResponseEntity<>(hospitalizationByPatients, HttpStatus.OK);
    }
    @GetMapping("by_doctors")
    public ResponseEntity<List<HospitalizationByDoctor>> hospitalizationByDoctor(){
        List<PatientRepository> patients = patientService.findall();
        List<HospitalizationHistory> hospitalizationHistories = hospitalizationHistoryService.findall();
        List<HospitalizationByDoctor> hospitalizationByDoctors =
            hospitalizationAdapter.adaptHospitalizationByDoctor(hospitalizationHistories,patients);

        return new ResponseEntity<>(hospitalizationByDoctors,HttpStatus.OK);
    }
   @PostMapping
    public ResponseEntity<HospitalizationHistory>post(@RequestBody HospitalizationHistory hospitalizationHistory){
        return new ResponseEntity<>(hospitalizationHistoryService.post(hospitalizationHistory),HttpStatus.CREATED);
   }

   @PutMapping
   public ResponseEntity<HospitalizationHistory> update(@RequestBody HospitalizationHistory hospitalizationHistory){
        return new ResponseEntity<>(hospitalizationHistoryService.update(hospitalizationHistory),HttpStatus.CREATED);
   }

   @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        hospitalizationHistoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
   }
}
