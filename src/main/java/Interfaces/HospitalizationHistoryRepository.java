package Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalizationHistoryRepository extends JpaRepository<HospitalizationHistoryRepository, Long> {
}
