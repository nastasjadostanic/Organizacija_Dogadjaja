package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ShipHistoryAppointment;

import java.util.List;

@Repository
public interface ShipHistoryAppointmentRepository extends JpaRepository<ShipHistoryAppointment, Long> {
    List<ShipHistoryAppointment> findByShipId(Long shipId );

}
