package Services;

import Controller.DoctorController;
import Interfaces.DoctorRepository;
import entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorRepository> findall(){
     return doctorRepository.findAll();
    }

    public static DoctorRepository findByid(Long id){
        return doctorRepository.findById(id).orElseThrow(null);
    }
   public Doctor post(DoctorController doctor){
        return doctorRepository.save(doctor);
   }

   public Doctor update(Doctor doctor){
        return doctorRepository.save(doctor);
   }

   public void delete(Long id){
        doctorRepository.findById(id);
   }
}
