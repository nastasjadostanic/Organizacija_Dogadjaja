package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.AdventureQuickAppointment;

import java.util.List;

@Repository
public interface AdventureQuickAppointmentRepository extends JpaRepository<AdventureQuickAppointment, Long> {
    List<AdventureQuickAppointment> findByInstructorId(Long instructorId );
    List<AdventureQuickAppointment> findByAdventureId(Long adventureId );

}