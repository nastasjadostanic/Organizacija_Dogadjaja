package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.AdventureAppointment;

import java.util.List;

@Repository
public interface AdventureAppointmentRepository extends JpaRepository<AdventureAppointment, Long> {
    List<AdventureAppointment> findByAdventureId(Long adventureId );
    List<AdventureAppointment> findByInstructorId(Long instructorId );

}
