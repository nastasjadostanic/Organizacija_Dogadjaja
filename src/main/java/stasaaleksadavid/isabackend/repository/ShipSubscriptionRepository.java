package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stasaaleksadavid.isabackend.model.ShipSubscription;

import java.util.List;

@Repository
public interface ShipSubscriptionRepository extends JpaRepository<ShipSubscription, Long> {
    List<ShipSubscription> findByShipId(Long shipId );


}
