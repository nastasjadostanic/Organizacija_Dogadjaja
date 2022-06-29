package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.CottageHistoryAppointment;


import java.util.List;

@Repository
public interface CottageHistoryAppointmentRepository extends JpaRepository<CottageHistoryAppointment, Long> {
    List<CottageHistoryAppointment> findByCottageId(Long cottageId );

}
