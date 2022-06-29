package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.AdventureAdditionalEquipment;

@Repository
public interface AdventureAdditionalEquipmentRepository extends JpaRepository<AdventureAdditionalEquipment,Long> {
}
