package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.CottageFreeAppointment;


import java.util.List;

@Repository
public interface CottageFreeAppointmentRepository extends JpaRepository<CottageFreeAppointment, Long> {
    List<CottageFreeAppointment> findByCottageId(Long cottageId );
}
