package stasaaleksadavid.isabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stasaaleksadavid.isabackend.model.ShipPricelistItem;

@Repository
public interface ShipPricelistItemRepository extends JpaRepository<ShipPricelistItem,Long> {
}
