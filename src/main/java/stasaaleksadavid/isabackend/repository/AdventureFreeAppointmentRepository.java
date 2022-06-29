package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.AdventureFreeAppointment;

import java.util.List;

@Repository
public interface AdventureFreeAppointmentRepository extends JpaRepository<AdventureFreeAppointment, Long> {
    List<AdventureFreeAppointment> findByInstructorId(Long instructorId );
    List<AdventureFreeAppointment> findByAdventureId(Long adventureId );
}
