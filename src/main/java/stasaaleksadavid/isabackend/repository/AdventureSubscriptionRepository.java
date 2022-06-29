package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.AdventureSubscription;

import java.util.List;

@Repository
public interface AdventureSubscriptionRepository extends JpaRepository<AdventureSubscription, Long> {
    List<AdventureSubscription> findByAdventureId(Long adventureId );


}
