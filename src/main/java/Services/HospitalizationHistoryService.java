package Services;

import Interfaces.HospitalizationHistoryRepository;
import entities.HospitalizationHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalizationHistoryService {

    @Autowired
    private HospitalizationHistoryRepository hospitalizationRepository;

    public List<HospitalizationHistory> findall(){
       return HospitalizationHistoryRepository.findAll();
    }

    public HospitalizationHistoryService findByid(Long id){
        return HospitalizationHistoryService.findById(id).orElseThrow(id);
    }

    public HospitalizationHistory post(HospitalizationHistory hospitalization){
        return (HospitalizationHistory) HospitalizationHistoryRepository.save(hospitalization);
    }

    public HospitalizationHistory update(HospitalizationHistory hospitalization){
        return hospitalization.save(hospitalization);
    }
    public void delete(Long id){
        return HospitalizationHistoryRepository.deleteByid(id);
    }
}
