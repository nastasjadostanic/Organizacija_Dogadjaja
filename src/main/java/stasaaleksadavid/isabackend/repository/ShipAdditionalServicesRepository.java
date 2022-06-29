package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ShipAdditionalServices;

@Repository
public interface ShipAdditionalServicesRepository extends JpaRepository<ShipAdditionalServices,Long> {
}
