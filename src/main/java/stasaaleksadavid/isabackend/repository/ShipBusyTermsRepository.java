package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.*;

@Repository
public interface ShipBusyTermsRepository extends JpaRepository<ShipBusyTerms,Long> {
}
