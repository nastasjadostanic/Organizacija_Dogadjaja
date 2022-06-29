package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.AdventureHistoryAppointment;


import java.util.List;

@Repository
public interface AdventureHistoryAppointmentRepository extends JpaRepository<AdventureHistoryAppointment, Long> {
    List<AdventureHistoryAppointment> findByAdventureId(Long adventureId );
    List<AdventureHistoryAppointment> findByInstructorId(Long instructorId );

}
