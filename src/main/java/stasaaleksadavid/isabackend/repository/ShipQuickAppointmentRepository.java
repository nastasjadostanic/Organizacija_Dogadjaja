package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ShipQuickAppointment;


import java.util.List;

@Repository
public interface ShipQuickAppointmentRepository extends JpaRepository<ShipQuickAppointment, Long> {
    List<ShipQuickAppointment> findByShipId(Long shipId );

}