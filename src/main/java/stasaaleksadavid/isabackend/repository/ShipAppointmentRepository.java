package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ShipAppointment;


import java.util.List;

@Repository
public interface ShipAppointmentRepository extends JpaRepository<ShipAppointment, Long> {
    List<ShipAppointment> findByShipId(Long shipId );

}
