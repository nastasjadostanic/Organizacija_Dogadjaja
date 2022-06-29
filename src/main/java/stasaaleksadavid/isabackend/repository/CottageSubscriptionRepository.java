package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stasaaleksadavid.isabackend.model.CottageSubscription;

import java.util.List;

@Repository
public interface CottageSubscriptionRepository extends JpaRepository<CottageSubscription, Long> {
    List<CottageSubscription> findByCottageId(Long cottageId );


}
