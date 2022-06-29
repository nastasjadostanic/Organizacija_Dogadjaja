package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ShipFreeAppointment;


import java.util.List;

@Repository
public interface ShipFreeAppointmentRepository extends JpaRepository<ShipFreeAppointment, Long> {
    List<ShipFreeAppointment> findByShipId(Long shipId );
}
