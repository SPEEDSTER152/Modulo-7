package Controller;

import Interfaces.PatientRepository;
import Services.PatientService;
import entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientRepository>> findall(){
        return new ResponseEntity<>(patientService.findall(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> post(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.post(patient),HttpStatus.CREATED);
    }
  @PutMapping
    public ResponseEntity<Patient> update(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.update(patient),HttpStatus.OK);
  }
  @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        patientService.delete(id);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
}
