package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ShipConfiguration;

@Repository
public interface ShipConfigurationRepository extends JpaRepository<ShipConfiguration,Long> {
}
